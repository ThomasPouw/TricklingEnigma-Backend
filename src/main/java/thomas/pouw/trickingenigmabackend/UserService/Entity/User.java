package thomas.pouw.trickingenigmabackend.UserService.Entity;

import com.fasterxml.jackson.annotation.*;
import thomas.pouw.trickingenigmabackend.LevelService.Entity.Sprite;
import thomas.pouw.trickingenigmabackend.RecordService.Entity.Record;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @JoinColumn(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name="email")
    private String email;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user" )//https://www.baeldung.com/jpa-one-to-one
    private List<Record> record;
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

    public String getName() {
        return name;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Record> getRecord() {
        return record;
    }

    public void setRecord(List<Record> record) {
        this.record = record;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
}
