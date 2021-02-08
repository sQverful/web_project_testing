package epam.testing_app.database;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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

            con = DriverManager.getConnection(getConnectionProperty());
        } catch (SQLException e) {
           // log.error("Cannot get a connection", e);
        }
        return con;
    }

    /**
     * Gets connection URL for mysql
     * @return A DB connection URL
     */
    public String getConnectionProperty() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/app.properties")) {
            properties.load(fileInputStream);
            return properties.getProperty("connection.url");
        } catch (IOException exception) {
            exception.getMessage();
            return null;
        }
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



}
