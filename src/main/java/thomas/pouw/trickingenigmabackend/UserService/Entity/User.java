package thomas.pouw.trickingenigmabackend.UserService.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {
    @Id
    @JoinColumn(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name="email")
    private String email;
    //@OneToOne
    //@PrimaryKeyJoinColumn(name = "nationality_id")
    //private Nationality nationality;
    public User(String name, String email){
        this.name= name;
        this.email = email;
    }

    public User() {}

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    //public Nationality getNationality() {
    //    return nationality;
    //}

    public void setId(UUID id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //public void setNationality(Nationality nationality) {
    //    this.nationality = nationality;
    //}
}
