package epam.testing_app.database.dao;

import epam.testing_app.database.DBManager;
import epam.testing_app.database.entity.User;

import java.sql.*;

/**
 * Data access object for User entity
 *
 * @author V. Dorosh
 */
public class UserDao {

    private static final String SQL_FIND_USER_BY_LOGIN =
            "SELECT * FROM user WHERE login=?";

    private static final String SQL_FIND_USER_BY_ID =
            "SELECT * FROM user WHERE id=?";

    private static final String SQL_UPDATE_USER =
            "UPDATE user SET password=?, name=?, surname=?, email=?"+
                    "	WHERE id=?";
    private static final String SQL_INSERT_NEW_USER = "INSERT INTO user" +
            "(id, login, name, surname, email, password, create_time, blocked, role_id)" +
            "VALUES(?, ?, ?, ?, ?, ?, now(), ?, ?)";


    public boolean insertUser(User user) {
        boolean res = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_INSERT_NEW_USER, Statement.RETURN_GENERATED_KEYS);
            int k = 1;
            long cid = user.getId();

            if (cid == 0) {
                pstmt.setNull(k++, Types.INTEGER);
            } else {
                pstmt.setLong(k++, user.getId());
            }

            pstmt.setString(k++, user.getLogin());
            pstmt.setString(k++, user.getName());
            pstmt.setString(k++, user.getSurname());
            pstmt.setString(k++, user.getEmail());
            pstmt.setString(k++, user.getPassword());
            pstmt.setBoolean(k++, user.isBlocked());
            pstmt.setInt(k++, user.getRoleId());

            if (pstmt.executeUpdate() > 0) {
                res = true;
            }


            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // TODO: find the solution
        }
        return res;
    }
    public User getUserById(Long id) {
        User user = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            UserMapper mapper = new UserMapper();
            pstmt = con.prepareStatement(SQL_FIND_USER_BY_ID);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = mapper.mapRow(rs);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return user;
    }

    public User getUserByLogin(String login) {
        User user = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            UserMapper mapper = new UserMapper();
            pstmt = con.prepareStatement(SQL_FIND_USER_BY_LOGIN);
            pstmt.setString(1, login);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = mapper.mapRow(rs);
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
        return user;
    }


    public void updateUser(User user) {
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            updateUser(con, user);
        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        } finally {
            DBManager.getInstance().commitAndClose(con);
        }
    }

    public void updateUser(Connection con, User user) throws SQLException {

        PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_USER);
        int k = 1;
        pstmt.setString(k++, user.getPassword());
        pstmt.setString(k++, user.getName());
        pstmt.setString(k++, user.getSurname());
        pstmt.setString(k++, user.getEmail());
        pstmt.executeUpdate();
        pstmt.close();
    }

    /**
     * Extracts a user from the result set row
     */
    private static class UserMapper implements EntityMapper<User> {
        @Override
        public User mapRow(ResultSet rs) {
                User user = new User();
                try {
                    user.setId(rs.getLong(DBFields.ENTITY_ID));
                    user.setLogin(rs.getString(DBFields.USER_LOGIN));
                    user.setName(rs.getString(DBFields.USER_NAME));
                    user.setSurname(rs.getString(DBFields.USER_SURNAME));
                    user.setEmail(rs.getString(DBFields.USER_EMAIL));
                    user.setPassword(rs.getString(DBFields.USER_PASSWORD));
                    user.setRoleId(rs.getInt(DBFields.USER_ROLE_ID));
                    user.setBlocked(rs.getBoolean(DBFields.USER_BLOCKED));
                    user.setCreateTime(rs.getTimestamp(DBFields.USER_CREATE_TIME));
                    return user;
            } catch (SQLException e) {
                throw new IllegalStateException();
            }
        }
    }

    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        System.out.println(userDao.getUserByLogin("test"));


    }
}

