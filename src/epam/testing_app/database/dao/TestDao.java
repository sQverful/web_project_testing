package epam.testing_app.database.dao;

import epam.testing_app.database.DBManager;
import epam.testing_app.database.entity.Subject;
import epam.testing_app.database.entity.Test;
import epam.testing_app.database.entity.User;

import java.sql.*;

/**
 *
 * Data access object for Test
 *
 * @author V. Dorosh
 */
public class TestDao {
    private static final String SQL_FIND_TEST_BY_NAME_UA =
            "SELECT * FROM test WHERE name_ua=?";

    private static final String SQL_FIND_TEST_BY_NAME_EN =
            "SELECT * FROM test WHERE name_en=?";

    private static final String SQL_FIND_TEST_BY_ID =
            "SELECT * FROM test WHERE id=?";

    private static final String SQL_UPDATE_TEST =
            "UPDATE test SET name_ua=?, name_en=?, complexity=?, blocked=?, timer=?, description_ua=?, description_en=?"+
                    " WHERE id=?";
    private static final String SQL_INSERT_NEW_TEST = "INSERT INTO test" +
            "(id, name_ua, name_en, complexity, requests_quantity, blocked, timer, description_ua, description_en, subject_id, create_time)" +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";

    private static final String SQL_DELETE_TEST_BY_ID = "DELETE FROM test WHERE id=?";

    public boolean updateSubject(Test test) {
        boolean result = false;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            result = updateSubject(con, test);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return result;
    }

    public boolean updateSubject(Connection con, Test test) throws SQLException {
        boolean result = false;
        PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_TEST);

        int k = 1;
        pstmt.setString(k++, test.getNameEN());
        pstmt.setString(k++, test.getNameUA());
        pstmt.setInt(k++, test.getComplexity());
        pstmt.setBoolean(k++, test.isBlocked());
        pstmt.setInt(k++, test.getTimer());
        pstmt.setString(k++, test.getDescriptionUA());
        pstmt.setString(k++, test.getDescriptionEN());
        pstmt.setLong(k++, test.getId());

        if (pstmt.executeUpdate() > 0) {
            result = true;
        }

        pstmt.close();
        return result;
    }

    public boolean deleteTestById(int id) {
        boolean result = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_DELETE_TEST_BY_ID);
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean insertNewTest(Test test) {
        boolean result = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_INSERT_NEW_TEST);

            int k = 1;
            pstmt = con.prepareStatement(SQL_INSERT_NEW_TEST, Statement.RETURN_GENERATED_KEYS);
            long cid = test.getId();

            if (cid == 0) {
                pstmt.setNull(k++, Types.INTEGER);
            } else {
                pstmt.setLong(k++, test.getId());
            }

            pstmt.setString(k++, test.getNameUA());
            pstmt.setString(k++, test.getNameEN());
            pstmt.setInt(k++, test.getComplexity());
            pstmt.setNull(k++, Types.NULL);
            pstmt.setBoolean(k++, test.isBlocked());
            pstmt.setInt(k++, test.getTimer());
            pstmt.setString(k++, test.getDescriptionUA());
            pstmt.setString(k++, test.getDescriptionEN());
            pstmt.setInt(k++, test.getSubjectId());

            if (pstmt.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Test getTestById(Long id) {
        Test test = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            TestMapper mapper = new TestMapper();
            pstmt = con.prepareStatement(SQL_FIND_TEST_BY_ID);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                test = mapper.mapRow(rs);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return test;
    }

    public Test getTestByNameUa(String nameUa) {
        Test test = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            TestMapper mapper = new TestMapper();
            pstmt = con.prepareStatement(SQL_FIND_TEST_BY_NAME_UA);
            pstmt.setString(1, nameUa);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                test = mapper.mapRow(rs);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return test;
    }

    public Test getTestByNameEn(String nameEn) {
        Test test = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            TestMapper mapper = new TestMapper();
            pstmt = con.prepareStatement(SQL_FIND_TEST_BY_NAME_EN);
            pstmt.setString(1, nameEn);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                test = mapper.mapRow(rs);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return test;
    }


    private static class TestMapper implements EntityMapper<Test> {
        @Override
        public Test mapRow(ResultSet rs) {
            Test test = new Test();

            try {
                test.setId(rs.getLong(DBFields.ENTITY_ID));
                test.setNameUA(rs.getString(DBFields.TEST_NAME_UA));
                test.setNameEN(rs.getString(DBFields.TEST_NAME_EN));
                test.setComplexity(rs.getInt(DBFields.TEST_COMPLEXITY));
                test.setRequestsQuantity(rs.getInt(DBFields.TEST_REQUESTS_QUANTITY));
                test.setBlocked(rs.getBoolean(DBFields.TEST_BLOCKED));
                test.setTimer(rs.getInt(DBFields.TEST_TIMER));
                test.setDescriptionUA(rs.getString(DBFields.TEST_DESCRIPTION_UA));
                test.setDescriptionEN(rs.getString(DBFields.TEST_DESCRIPTION_EN));
                test.setSubjectId(rs.getInt(DBFields.TEST_SUBJECT_ID));
                test.setCreatedOn(rs.getTimestamp(DBFields.TEST_CREATE_TIME));

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return test;
        }
    }


    public static void main(String[] args) {

        TestDao testDao = new TestDao();

  //      System.out.println(testDao.insertNewTest(Test.createTest("test", "тест",
 //               "test", "тест", 4, false, 50, 0, 100)));

        Test test = new Test();
        test = Test.createTest("trial", "трайл", "trialDesc", "трайлОпис",
                4, false, 55, 0, 50);
        test.setId(1L);
       // System.out.println(testDao.updateSubject(test));
        //System.out.println(testDao.getTestByNameEn("трайл"));
        System.out.println(testDao.getTestById(1L));

    }
}
