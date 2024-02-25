package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class which provides easy connection to the database and makes manipulation with it easier. Only ONE connection can be active at any one time.
 */
public class DatabaseConnection {

    private static DatabaseConnection instance = null;
    private final String url;
    private final String username;
    private final String password;
    private Connection connection;

    private DatabaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Method for creation a connection. It loads all data from config file
     * @return The connection
     * @throws IOException
     */
    public static DatabaseConnection createConnection() throws IOException {
        if(instance == null){
            Properties prop = new Properties();

            FileInputStream ip = new FileInputStream("src/main/resources/database/config.properties");

            prop.load(ip);

            instance = new DatabaseConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
        }
        return instance;
    }




    /**
     * Returns the connection if any method needs to be called directly on it
     * @return The connection
     * @throws NullPointerException If the connection was not established for this session (i.e. the connect() method was not used yet)
     */
    public Connection getConnection() throws NullPointerException{
        if(connection == null) throw new NullPointerException("No connection was established for this session!");
        return connection;
    }

    /**
     * Establishes a connection
     * @throws SQLException If something goes wrong with connecting
     * @throws NullPointerException When I think about it, this exception is maybe useless here... never mind I'll leave it here
     */
    public void connect() throws SQLException, NullPointerException{
        connection = DriverManager.getConnection(url, username, password);
        if(connection == null) throw new NullPointerException("Could not establish connection");
    }

    /**
     * Closes the connection
     * @throws SQLException If something goes wrong with closing the connection
     * @throws NullPointerException If the connection was not established yet
     */
    public void close() throws SQLException, NullPointerException {
        if(connection == null) throw new NullPointerException("No connection was established for this session");
        connection.close();
        instance = null;
    }

    /**
     * Calls COMMIT on the database
     * @throws SQLException If something goes wrong with calling the COMMIT
     * @throws NullPointerException If the connection was not established yet
     */
    public void commit() throws SQLException, NullPointerException {
        if(connection == null) throw new NullPointerException("No connection was established for this session");

        String sql = "COMMIT";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.executeUpdate();

        ps.close();
    }
}