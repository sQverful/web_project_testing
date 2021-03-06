package epam.testing_app.database.dao;

import epam.testing_app.database.DBManager;
import epam.testing_app.database.entity.Answer;
import epam.testing_app.database.entity.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Data access object for Answer
 *
 * @author V.Dorosh
 */
public class AnswerDao {

    private static final String SQL_FIND_ALL_ANSWERS =
            "SELECT * FROM answer";

    private static final String SQL_FIND_ALL_ANSWERS_BY_QUESTION_ID =
            "SELECT * FROM answer WHERE question_id=?";

    private static final String SQL_FIND_ANSWER_BY_ANSWER_UA =
            "SELECT * FROM answer WHERE answer_ua=?";

    private static final String SQL_FIND_ANSWER_BY_ANSWER_EN =
            "SELECT * FROM answer WHERE answer_en=?";

    private static final String SQL_FIND_ANSWER_BY_ID =
            "SELECT * FROM answer WHERE id=?";

    private static final String SQL_UPDATE_ANSWER =
            "UPDATE answer SET answer_ua=?, answer_en=?, correct=?"+
                    " WHERE id=?";
    private static final String SQL_UPDATE_ANSWER_CORRECT =
            "UPDATE answer SET correct=?"+
                    " WHERE id=?";
    private static final String SQL_INSERT_NEW_ANSWER = "INSERT INTO answer" +
            "(id, answer_ua, answer_en, correct, question_id)" +
            "VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_ANSWER_BY_ID = "DELETE FROM answer WHERE id=?";

    public List<Answer> getAnswersListByQuestionList(List<Question> questionList) {
        List<Answer> answerList = new ArrayList<>();
        List<Answer> foundedList = null;
        for (Question q : questionList) {
            foundedList = findAllAnswersByQuestionId(q.getId());
            answerList.addAll(foundedList);
        }
        return answerList;
    }

    public Map<Question, List<Answer>> getAnswersMapByQuestionList(List<Question> questionList) {
        Map<Question, List<Answer>> map = new HashMap<>();
        for (Question q : questionList) {
            map.put(q, findAllAnswersByQuestionId(q.getId()));
        }
        return map;
    }

    public List<Answer> findAllAnswersByQuestionId(int questionId) {
        List<Answer> answerList = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        AnswerMapper mapper = new AnswerMapper();

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_ALL_ANSWERS_BY_QUESTION_ID);
            pstmt.setInt(1, questionId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                answerList.add(mapper.mapRow(rs));
            }
            con.close();
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answerList;
    }

    public List<Answer> findAllAnswers() {
        List<Answer> answerList = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        AnswerMapper mapper = new AnswerMapper();

        try {
            con = DBManager.getInstance().getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_FIND_ALL_ANSWERS);
            while (rs.next()) {
                answerList.add(mapper.mapRow(rs));
            }
            con.close();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answerList;
    }

    public boolean deleteAnswerById(int id) {
        boolean result = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_DELETE_ANSWER_BY_ID);
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean updateAnswerCorrect(int answerId, boolean isCorrect) {
        boolean result = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE_ANSWER_CORRECT);
            int k = 1;
            pstmt.setBoolean(k++, isCorrect);
            pstmt.setInt(k++, answerId);
            if (pstmt.executeUpdate() > 0) {
                result = true;
            }
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return result;
    }

    public boolean updateAnswer(Answer answer) {
        boolean result = false;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            result = updateAnswer(con, answer);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return result;
    }

    public boolean updateAnswer(Connection con, Answer answer) throws SQLException {
        boolean result = false;
        PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_ANSWER);

        int k = 1;
        pstmt.setString(k++, answer.getAnswerUA());
        pstmt.setString(k++, answer.getAnswerEN());
        pstmt.setBoolean(k++, answer.getCorrect());

        if (pstmt.executeUpdate() > 0) {
            result = true;
        }

        pstmt.close();
        return result;
    }

    public Answer getAnswerByAnswerUa(String answer_ua) {
        Answer answer = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_ANSWER_BY_ANSWER_UA);
            pstmt.setString(1, answer_ua);
            rs = pstmt.executeQuery();

            AnswerMapper mapper = new AnswerMapper();

            if (rs.next()) {
                answer = mapper.mapRow(rs);
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        }
        return answer;
    }
    public Answer getAnswerByAnswerEn(String answer_en) {
        Answer answer = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_ANSWER_BY_ANSWER_EN);
            pstmt.setString(1, answer_en);
            rs = pstmt.executeQuery();

            AnswerMapper mapper = new AnswerMapper();

            if (rs.next()) {
                answer = mapper.mapRow(rs);
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        }
        return answer;
    }

    public Answer getAnswerById(int id) {
        Answer answer = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_ANSWER_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            AnswerMapper mapper = new AnswerMapper();

            if (rs.next()) {
                answer = mapper.mapRow(rs);
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        }
        return answer;
    }

    public boolean insertAnswer(Answer answer) {
        boolean result = false;
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_INSERT_NEW_ANSWER);
            int k = 1;

            pstmt.setNull(k++, Types.INTEGER);
            pstmt.setString(k++, answer.getAnswerUA());
            pstmt.setString(k++, answer.getAnswerEN());
            pstmt.setBoolean(k++, answer.getCorrect());
            pstmt.setLong(k++, answer.getQuestionId());

            if (pstmt.executeUpdate() > 0) {
                result = true;
            }

            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    private static class AnswerMapper implements EntityMapper<Answer> {
        @Override
        public Answer mapRow(ResultSet rs) {
            Answer answer = new Answer();

            try {
                answer.setId(rs.getInt(DBFields.ENTITY_ID));
                answer.setAnswerEN(rs.getString(DBFields.ANSWER_EN));
                answer.setAnswerUA(rs.getString(DBFields.ANSWER_UA));
                answer.setCorrect(rs.getBoolean(DBFields.ANSWER_CORRECT));
                answer.setQuestionId(rs.getInt(DBFields.ANSWER_QUESTION_ID));
            } catch (SQLException e) {
                throw new IllegalStateException();
            }
            return answer;
        }
    }




}
