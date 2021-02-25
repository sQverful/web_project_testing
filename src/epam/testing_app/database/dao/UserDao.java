package epam.testing_app.database.dao;

import epam.testing_app.database.DBManager;
import epam.testing_app.database.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object for User entity
 *
 * @author V. Dorosh
 */
public class UserDao {

    private static final String SQL_FIND_ALL_USERS =
            "SELECT * FROM user";

    private static final String SQL_FIND_USER_BY_LOGIN =
            "SELECT * FROM user WHERE login=?";

    private static final String SQL_FIND_USER_BY_ID =
            "SELECT * FROM user WHERE id=?";

    private static final String SQL_UPDATE_USER_BLOCKED =
            "UPDATE user SET blocked=?"+
                    "	WHERE id=?";

    private static final String SQL_UPDATE_USER =
            "UPDATE user SET password=?, name=?, surname=?, email=?, blocked=?, role_id=?"+
                    "	WHERE id=?";

    private static final String SQL_INSERT_NEW_USER = "INSERT INTO user" +
            "(id, login, name, surname, email, password, create_time, blocked, role_id)" +
            "VALUES(?, ?, ?, ?, ?, ?, now(), ?, ?)";

    private static final String SQL_DELETE_USER = "DELETE FROM user WHERE id=?";


    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        UserMapper mapper = new UserMapper();

        try {
            con = DBManager.getInstance().getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_FIND_ALL_USERS);

            while (rs.next()) {
                users.add(mapper.mapRow(rs));
            }

            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }

        return users;
    }

    public boolean updateUserBlocked(int userID, boolean isBlocked) {
        boolean result = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE_USER_BLOCKED);
            int k = 1;
            pstmt.setBoolean(k++, isBlocked);
            pstmt.setInt(k++, userID);
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
    public boolean insertUser(User user) {
        boolean res = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_INSERT_NEW_USER, Statement.RETURN_GENERATED_KEYS);
            int k = 1;
            int cid = user.getId();

            if (cid == 0) {
                pstmt.setNull(k++, Types.INTEGER);
            } else {
                pstmt.setInt(k++, user.getId());
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
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // TODO: find the solution
        }
        return res;
    }
    public User getUserById(int id) {
        User user = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            UserMapper mapper = new UserMapper();
            pstmt = con.prepareStatement(SQL_FIND_USER_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = mapper.mapRow(rs);
            }

            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
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
            con.close();
        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        } finally {
            return user;
        }
    }


    public boolean deleteUserById(int id) {
        boolean result = false;
        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_DELETE_USER);
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean updateUser(User user) {
        boolean result = false;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            result = updateUser(con, user);
            con.close();
        } catch (SQLException e) {
            DBManager.getInstance().rollbackAndClose(con);
            e.printStackTrace();
        } finally {
        }
        return result;
    }

    public boolean updateUser(Connection con, User user) throws SQLException {
        boolean result = false;

        PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_USER);
        int k = 1;
        pstmt.setString(k++, user.getPassword());
        pstmt.setString(k++, user.getName());
        pstmt.setString(k++, user.getSurname());
        pstmt.setString(k++, user.getEmail());
        pstmt.setBoolean(k++, user.isBlocked());
        pstmt.setInt(k++, user.getRoleId());
        pstmt.setInt(k++, user.getId());
        if (pstmt.executeUpdate() > 0) {
            result = true;
        }
        pstmt.close();
        return result;
    }

    /**
     * Extracts a user from the result set row
     */
    private static class UserMapper implements EntityMapper<User> {
        @Override
        public User mapRow(ResultSet rs) {
                User user = new User();
                try {
                    user.setId(rs.getInt(DBFields.ENTITY_ID));
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

//       System.out.println(userDao.insertUser(User.createUser("test12", "test", "test",
//               "test12@test.com", "test", true, 1)));
        System.out.println(userDao.findAllUsers());

//        System.out.println(userDao.insertUser(User.createUser("admin", "admin", "admin",
//                "admin@test.com", "admin", false, 2)));



    }
}

