package tccavy.tricklingenigma.userservice.UserService.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@ApiIgnore
@Entity
@Table(name = "user", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Cloneable {
    @Id
    @JoinColumn(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "secret")
    private String secret;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;


    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    //@OneToMany(cascade = CascadeType.ALL, mappedBy="user" )//https://www.baeldung.com/jpa-one-to-one
    //private List<Record> record;
    public User(String name){
        this.name= name;
    }

    public User() {}

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public String getSecret() {
        return secret;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
    public User clone() {
        // Note2: Catch checked exception here so client or subclass doesn't need to.
        User result = null;
        try {
            result = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Unable to clone.", e);
        }
        return result;
    }
}
