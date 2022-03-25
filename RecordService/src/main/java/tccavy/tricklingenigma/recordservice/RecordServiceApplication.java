package tccavy.tricklingenigma.recordservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class RecordServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecordServiceApplication.class, args);
    }

} //http://localhost:8000/swagger-ui/index.html#/

