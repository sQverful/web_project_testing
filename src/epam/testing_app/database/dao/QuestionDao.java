package epam.testing_app.database.dao;

import epam.testing_app.database.DBManager;
import epam.testing_app.database.entity.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object for Question
 *
 * @author V.Dorosh
 */
public class QuestionDao {
    private static final String SQL_FIND_QUESTION_BY_QUESTION_UA =
            "SELECT * FROM question WHERE question_ua=?";

    private static final String SQL_FIND_QUESTION_BY_QUESTION_EN =
            "SELECT * FROM question WHERE question_en=?";

    private static final String SQL_FIND_QUESTION_BY_ID =
            "SELECT * FROM question WHERE id=?";

    private static final String SQL_FIND_ALL_QUESTION_BY_TEST_ID =
            "SELECT * FROM question WHERE test_id=?";

    private static final String SQL_UPDATE_QUESTION =
            "UPDATE question SET question_ua=?, question_en=?"+
                    " WHERE id=?";
    private static final String SQL_INSERT_NEW_QUESTION = "INSERT INTO question" +
            "(id, question_ua, question_en, test_id)" +
            "VALUES(?, ?, ?, ?)";
    private static final String SQL_DELETE_QUESTION_BY_ID = "DELETE FROM question WHERE id=?";

    public List<Question> findAllQuestionsByTestId(int testID) {
        List<Question> questionList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        QuestionMapper mapper = new QuestionMapper();

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_ALL_QUESTION_BY_TEST_ID);
            pstmt.setInt(1, testID);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                questionList.add(mapper.mapRow(rs));
            }
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return questionList;
    }

    public boolean deleteQuestionById(int id) {
        boolean result = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_DELETE_QUESTION_BY_ID);
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean updateQuestion(Question question) {
        boolean result = false;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            result = updateQuestion(con, question);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return result;
    }

    public boolean updateQuestion(Connection con, Question question) throws SQLException {
        boolean result = false;
        PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_QUESTION);

        int k = 1;
        pstmt.setString(k++, question.getQuestionUA());
        pstmt.setString(k++, question.getQuestionEN());

        if (pstmt.executeUpdate() > 0) {
            result = true;
        }

        pstmt.close();
        return result;
    }

    public Question getQuestionByQuestionUa(String question_ua) {
        Question question = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_QUESTION_BY_QUESTION_UA);
            pstmt.setString(1, question_ua);
            rs = pstmt.executeQuery();

            QuestionMapper mapper = new QuestionMapper();

            if (rs.next()) {
                question = mapper.mapRow(rs);
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        }
        return question;
    }

    public Question getQuestionByQuestionEn(String question_en) {
        Question subject = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_QUESTION_BY_QUESTION_EN);
            pstmt.setString(1, question_en);
            rs = pstmt.executeQuery();

            QuestionMapper mapper = new QuestionMapper();

            if (rs.next()) {
                subject = mapper.mapRow(rs);
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        }
        return subject;
    }

    public Question getQuestionById(int id) {
        Question question = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_QUESTION_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            QuestionMapper mapper = new QuestionMapper();

            if (rs.next()) {
                question = mapper.mapRow(rs);
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        }
        return question;
    }

    public boolean insertQuestion(Question question) {
        boolean result = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_INSERT_NEW_QUESTION);

            int k = 1;


            pstmt.setNull(k++, Types.INTEGER);
            pstmt.setString(k++, question.getQuestionUA());
            pstmt.setString(k++, question.getQuestionEN());
            pstmt.setLong(k++, question.getTestId());

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
    private static class QuestionMapper implements EntityMapper<Question> {
        @Override
        public Question mapRow(ResultSet rs) {
            Question question = new Question();

            try {
                question.setId(rs.getInt(DBFields.ENTITY_ID));
                question.setQuestionUA(rs.getString(DBFields.QUESTION_UA));
                question.setQuestionEN(rs.getString(DBFields.QUESTION_EN));
                question.setTestId(rs.getInt(DBFields.QUESTION_TEST_ID));
            } catch (SQLException e) {
                throw new IllegalStateException();
            }
            return question;
        }
    }

}
