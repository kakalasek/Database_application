package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public static DatabaseConnection createConnection(String url, String username, String password){
        if(instance == null){
            instance = new DatabaseConnection(url, username, password);
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
}