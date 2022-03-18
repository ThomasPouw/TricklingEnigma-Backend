package thomas.pouw.trickingenigmabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import thomas.pouw.trickingenigmabackend.LevelService.WordDictionary.ScrabbleDictionary;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class TrickingEnigmaBackendApplication {
    private final String url = "jdbc:postgresql://localhost:5433/TricklingEnigma";
    private final String user = "TricklingEnigma";
    private final String password = "root";
    public Connection connect(){
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
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT");
            }
        };
    }
    public static void main(String[] args){
        TrickingEnigmaBackendApplication trickingEnigmaBackendApplication = new TrickingEnigmaBackendApplication();
        trickingEnigmaBackendApplication.connect();
        SpringApplication.run(TrickingEnigmaBackendApplication.class, args);
    }

}
