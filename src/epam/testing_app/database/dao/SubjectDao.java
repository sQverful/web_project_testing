package epam.testing_app.database.dao;

import epam.testing_app.database.DBManager;
import epam.testing_app.database.entity.Subject;
import epam.testing_app.database.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object for Subject
 *
 * @author V.Dorosh
 */
public class SubjectDao {

    private static final String SQL_FIND_ALL_ADMIN_DETAILS =
            "SELECT subject.admin_id, user.name, user.surname, user.email " +
                    "FROM subject " +
                    "INNER JOIN user " +
                    "ON subject.admin_id = user.id";

    private static final String SQL_FIND_ALL_SUBJECTS =
            "SELECT * FROM subject";

    private static final String SQL_FIND_SUBJECT_BY_NAME_UA =
            "SELECT * FROM subject WHERE name_ua=?";

    private static final String SQL_FIND_SUBJECT_BY_NAME_EN =
            "SELECT * FROM subject WHERE name_en=?";

    private static final String SQL_FIND_SUBJECT_BY_ID =
            "SELECT * FROM subject WHERE id=?";

    private static final String SQL_UPDATE_SUBJECT =
            "UPDATE subject SET name_ua=?, name_en=?, description_ua=?, description_en=?"+
                    " WHERE id=?";
    private static final String SQL_INSERT_NEW_SUBJECT = "INSERT INTO subject" +
            "(id, name_ua, name_en, description_ua, description_en, admin_id, create_time)" +
            "VALUES(?, ?, ?, ?, ?, ?, now())";

    private static final String SQL_DELETE_BY_ID = "DELETE FROM subject WHERE id=?";

    /**
     * This method gets additional details about admin
     * SQL request returns: subject.admin_id, user.name, user.surname. user.email
     *
     * @return List<User>
     */
    public List<User> findAllAdminDetails() {
        List<User> adminsList = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        AdminDetailsMapper mapper = new AdminDetailsMapper();
        try {
            con = DBManager.getInstance().getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_FIND_ALL_ADMIN_DETAILS);

            while (rs.next()) {
                adminsList.add(mapper.mapRow(rs));
            }

            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            DBManager.getInstance().commitAndClose(con);
        }
        return adminsList;
    }

    public List<Subject> findAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        SubjectMapper mapper = new SubjectMapper();

        try {
            con = DBManager.getInstance().getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_FIND_ALL_SUBJECTS);

            while (rs.next()) {
                subjects.add(mapper.mapRow(rs));
            }

            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            DBManager.getInstance().commitAndClose(con);
        }

        return subjects;
    }
    public boolean deleteSubjectById(int id) {
        boolean result = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_DELETE_BY_ID);
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() > 0) {
                result = true;
            }
            con.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean updateSubject(Subject subject) {
        boolean result = false;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            result = updateSubject(con, subject);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            DBManager.getInstance().commitAndClose(con);
        }
        return result;
    }

    public boolean updateSubject(Connection con, Subject subject) throws SQLException {
        boolean result = false;
        PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_SUBJECT);

        int k = 1;
        pstmt.setString(k++, subject.getNameUA());
        pstmt.setString(k++, subject.getNameEN());
        pstmt.setString(k++, subject.getDescriptionUA());
        pstmt.setString(k++, subject.getDescriptionEN());
        pstmt.setLong(k++, subject.getId());

        if (pstmt.executeUpdate() > 0) {
            result = true;
        }

        pstmt.close();
        return result;
    }

    public Subject getSubjectByNameUa(String name_ua) {
        Subject subject = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_SUBJECT_BY_NAME_UA);
            pstmt.setString(1, name_ua);
            rs = pstmt.executeQuery();

            SubjectMapper subjectMapper = new SubjectMapper();

            if (rs.next()) {
                subject = (Subject) subjectMapper.mapRow(rs);
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

    public Subject getSubjectById(int id) {
        Subject subject = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_SUBJECT_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            SubjectMapper subjectMapper = new SubjectMapper();

            if (rs.next()) {
                subject = subjectMapper.mapRow(rs);
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

    public Subject getSubjectByNameEn(String name_en) {
        Subject subject = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_SUBJECT_BY_NAME_EN);
            pstmt.setString(1, name_en);
            rs = pstmt.executeQuery();

            SubjectMapper subjectMapper = new SubjectMapper();

            if (rs.next()) {
                subject = (Subject) subjectMapper.mapRow(rs);
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

    public boolean insertSubject(Subject subject) {
        boolean result = false;

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_INSERT_NEW_SUBJECT, Statement.RETURN_GENERATED_KEYS);
            int k = 1;
            long id = subject.getId();

            if (id == 0) {
                pstmt.setNull(k++, Types.INTEGER);
            } else {
                pstmt.setLong(k++, subject.getId());
            }
            pstmt.setString(k++, subject.getNameUA());
            pstmt.setString(k++, subject.getNameEN());
            pstmt.setString(k++, subject.getDescriptionUA());
            pstmt.setString(k++, subject.getDescriptionEN());
            pstmt.setInt(k++, subject.getAdminId());

            if (pstmt.executeUpdate() > 0) {
                result = true;
            }

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Extracts a user (admin) from the result set row
     * Sets admin details in user object
     *
     */
    private static class AdminDetailsMapper implements EntityMapper<User> {
        @Override
        public User mapRow(ResultSet rs) {
            User user = new User();
            try {
                user.setId(rs.getInt(DBFields.SUBJECT_ADMIN_ID));
                user.setName(rs.getString(DBFields.USER_NAME));
                user.setSurname(rs.getString(DBFields.USER_SURNAME));
                user.setEmail(rs.getString(DBFields.USER_EMAIL));
                return user;
            } catch (SQLException e) {
                throw new IllegalStateException();
            }
        }
    }

    /**
     * Extracts a subject from the result set row
     */
    private static class SubjectMapper implements EntityMapper<Subject> {

        @Override
        public Subject mapRow(ResultSet rs) {
            Subject subject = new Subject();

            try {
                subject.setId(rs.getInt(DBFields.ENTITY_ID));
                subject.setNameUA(rs.getString(DBFields.SUBJECT_NAME_UA));
                subject.setNameEN(rs.getString(DBFields.SUBJECT_NAME_EN));
                subject.setDescriptionUA(rs.getString(DBFields.SUBJECT_DESCRIPTION_UA));
                subject.setDescriptionEN(rs.getString(DBFields.SUBJECT_DESCRIPTION_EN));
                subject.setAdminId(rs.getInt(DBFields.SUBJECT_ADMIN_ID));
                subject.setCreatedOn(rs.getTimestamp(DBFields.SUBJECT_CREATE_TIME));
            } catch (SQLException e) {
                throw new IllegalStateException();
            }
            return subject;
        }
    }



}

