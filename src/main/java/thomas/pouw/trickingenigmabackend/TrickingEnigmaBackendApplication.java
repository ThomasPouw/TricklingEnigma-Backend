package thomas.pouw.trickingenigmabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import thomas.pouw.trickingenigmabackend.Configuration.DatabaseConfig;
import thomas.pouw.trickingenigmabackend.LevelService.WordDictionary.ScrabbleDictionary;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
@EnableWebMvc
public class TrickingEnigmaBackendApplication {

    public static void main(String[] args){
        TrickingEnigmaBackendApplication trickingEnigmaBackendApplication = new TrickingEnigmaBackendApplication();
        DatabaseConfig.connect();
        SpringApplication.run(TrickingEnigmaBackendApplication.class, args);
    }
    //http://localhost:8080/swagger-ui/index.html#/

}
