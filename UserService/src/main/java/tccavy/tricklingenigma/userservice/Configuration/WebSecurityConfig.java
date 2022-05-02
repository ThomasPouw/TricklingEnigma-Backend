package tccavy.tricklingenigma.userservice.Configuration;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

//@Configuration
//@EnableWebSecurity
//public class CorsConfig {
//    //Welcome to Cors hell
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedMethods("GET", "POST", "PUT","OPTIONS", "DELETE")
//                        .allowedOrigins("http://localhost:4200");
//                        //.allowedHeaders("Content-Type", "Accept", "X-Requested-With");
//            }
//        };
//    }
//}
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .httpBasic();
    }
}
