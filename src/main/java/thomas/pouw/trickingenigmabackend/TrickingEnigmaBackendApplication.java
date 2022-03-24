package thomas.pouw.trickingenigmabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import thomas.pouw.trickingenigmabackend.Configuration.DatabaseConfig;

@SpringBootApplication
@EnableWebMvc
public class TrickingEnigmaBackendApplication {

    public static void main(String[] args){
        DatabaseConfig.connect();
        SpringApplication.run(TrickingEnigmaBackendApplication.class, args);
    }
    //http://localhost:8080/swagger-ui/index.html#/

}
