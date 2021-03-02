package epam.testing_app.database;

import org.apache.log4j.Logger;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Database manager for mysql.
 *
 * @author V.Dorosh
 */
public class DBManager {

    private DBManager() {
        //nothing to do
    }

    private static final Logger log = Logger.getLogger(DBManager.class);

    private static DBManager instance;

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    /**
     * Returns a DB connection from the Pool Connections. Before using this
     * method you must configure the Date Source and the Connections Pool in your
     * WEB_APP_ROOT/META-INF/context.xml file.
     *
     * @return A DB connection.
     */
    public Connection getConnection() {

        Connection con = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");

            DataSource ds = (DataSource) envContext.lookup("jdbc/testing");
            con = ds.getConnection();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return con;
    }


    /**
     * DB util method
     * Commits and close the given connection.
     *
     * @param con
     *            Connection to be committed and closed.
     */
    public void commitAndClose(Connection con) {
        try {
            con.commit();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * DB util method
     * Rollbacks and close the given connection.
     *
     * @param con
     *            Connection to be rollbacked and closed.
     */
    public void rollbackAndClose(Connection con) {
        try {
            con.rollback();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }



}
