package tccavy.tricklingenigma.levelservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = "jdbc:postgresql://localhost:5433/User";
    private static final String user = "TricklingEnigma";
    private static final String password = "root";
    public static Connection connect(){
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
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
