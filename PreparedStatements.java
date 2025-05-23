
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PreparedStatements {
    private Connection connection;
    String user, pass, url;

    public PreparedStatements(){

    }

public boolean setConnection(String url, String user, String pass) {
    try {
        connection = DriverManager.getConnection(url, user, pass);
        System.out.println("Database connection established.");
        return true;
    } catch (SQLException e) {
        System.err.println("Failed to establish database connection: " + e.getMessage());
        return false;
    }
}


    public Connection getConnection(){
        return connection;
    }

}
