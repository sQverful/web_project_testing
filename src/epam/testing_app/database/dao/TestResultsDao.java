package epam.testing_app.database.dao;

import epam.testing_app.database.DBManager;
import epam.testing_app.database.entity.Answer;
import epam.testing_app.database.entity.TestResult;

import java.sql.*;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * Data access object for TestResult table
 *
 * @author V.Dorosh
 */
public class TestResultsDao {

    private static final String SQL_FIND_ALL_TEST_RESULTS = "SELECT * FROM test_result";

    private static final String SQL_FIND_TEST_RESULT_BY_ID = "SELECT * FROM test_result WHERE id=?";

    private static final String SQL_FIND_ALL_TEST_RESULTS_BY_USER_AND_TEST_ID = "SELECT * FROM test_result WHERE user_id=? AND test_id=?";

    private static final String SQL_FIND_ALL_TEST_RESULTS_BY_USER_ID = "SELECT * FROM test_result WHERE user_id=?";

    private static final String SQL_FIND_ALL_TEST_RESULTS_BY_TEST_ID = "SELECT * FROM test_result WHERE test_id=?";

    private static final String SQL_INSERT_NEW_TEST_RESULT = "INSERT INTO test_result " +
            "(id, result, user_id, test_id, create_time) VALUES (?, ?, ?, ?, now())";

    public TestResult getTestResultByID(int id) {
        TestResult testResult = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_TEST_RESULT_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            TestResultsMapper mapper = new TestResultsMapper();

            while (rs.next()) {
                testResult = mapper.mapRow(rs);
            }

            pstmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return testResult;
    }

    public List<TestResult> finaAllTestResultsByUserID(int userID) {
        List<TestResult> testResults = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TestResultsMapper mapper = new TestResultsMapper();

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_TEST_RESULT_BY_ID);
            pstmt.setInt(1, userID);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                testResults.add(mapper.mapRow(rs));
            }

            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return testResults;
    }

    public List<TestResult> findAllTestResultsByUserIDAndTestID(int userID, int testID) {
        List<TestResult> testResults = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TestResultsMapper mapper = new TestResultsMapper();

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_ALL_TEST_RESULTS_BY_USER_AND_TEST_ID);
            pstmt.setInt(1, userID);
            pstmt.setInt(2, testID);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                testResults.add(mapper.mapRow(rs));
            }

            pstmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return testResults;
    }
    public boolean insertTestResult(TestResult testResult) {
        boolean result = false;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_INSERT_NEW_TEST_RESULT, Statement.RETURN_GENERATED_KEYS);
            int k = 1;

            pstmt.setNull(k++, Types.INTEGER);
            pstmt.setInt(k++, testResult.getResult());
            pstmt.setInt(k++, testResult.getUserId());
            pstmt.setInt(k++, testResult.getTestId());

            if (pstmt.executeUpdate() > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    testResult.setId(rs.getInt(1));
                }
                result = true;
            }

            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static class TestResultsMapper implements EntityMapper<TestResult> {
        @Override
        public TestResult mapRow(ResultSet rs) {
            TestResult testResult = new TestResult();

            try {
                testResult.setId(rs.getInt(DBFields.ENTITY_ID));
                testResult.setResult(rs.getInt(DBFields.TEST_RESULT_RESULT));
                testResult.setUserId(rs.getInt(DBFields.TEST_RESULT_USER_ID));
                testResult.setTestId(rs.getInt(DBFields.TEST_RESULT_TEST_ID));
                testResult.setCreatedOn(rs.getTimestamp(DBFields.TEST_RESULT_CREATE_TIME));
            } catch (SQLException e) {
                throw new IllegalStateException();
            }
            return testResult;
        }
    }
    public static void main(String[] args) {
        Timer timer = new Timer();
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis() + 50 * 60_000);

        System.out.println(timestamp1);
        System.out.println(timestamp2);
        System.out.println(timestamp2.after(timestamp1));
    }
}
