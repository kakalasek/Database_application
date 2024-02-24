package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

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

    public static DatabaseConnection createConnection() throws IOException {
        if(instance == null){
            Properties prop = new Properties();

            FileInputStream ip = new FileInputStream("src/main/resources/database/config.properties");

            prop.load(ip);

            instance = new DatabaseConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
        }
        return instance;
    }

    public Connection getConnection(){
        if(connection == null) throw new NullPointerException("No connection was established for this session!");
        return connection;
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        if(connection == null) throw new NullPointerException("Could not establish connection");
    }

    public void close() throws SQLException {
        if(connection == null) throw new NullPointerException("No connection was established for this session");
        connection.close();
        instance = null;
    }

    public void commit() throws SQLException {
        if(connection == null) throw new NullPointerException("No connection was established for this session");

        String sql = "COMMIT";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.executeUpdate();

        ps.close();
    }
}