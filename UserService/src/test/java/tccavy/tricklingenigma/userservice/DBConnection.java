package tccavy.tricklingenigma.userservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String url = "jdbc:postgresql://localhost:5433/User";
    private static String user = "TricklingEnigma";
    private static String password = "root";
    public static Connection connect(String URL, String user, String password){
        Connection conn = null;
        DBConnection.url = URL;
        DBConnection.user = user;
        DBConnection.password = password;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DBConnection.url, DBConnection.user, DBConnection.password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        return conn;
    }
    //https://examples.javacodegeeks.com/core-java/mockito/mockito-mock-database-connection-example/
}
