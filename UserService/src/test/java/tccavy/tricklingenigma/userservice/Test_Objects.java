package tccavy.tricklingenigma.userservice;

import tccavy.tricklingenigma.userservice.UserService.Entity.Nationality;
import tccavy.tricklingenigma.userservice.UserService.Entity.User;

import java.util.UUID;

public class Test_Objects {
    public User user() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setSecret("↑↑↓↓←→←→BA");
        user.setName("John Doe");
        user.setNationality(nationality());
        return user;
    }

    public Nationality nationality() {
        Nationality nationality = new Nationality();
        nationality.setId(UUID.randomUUID());
        nationality.setName("JohnDoeLand");
        nationality.setFlag("Flag");
        return nationality;
    }
}