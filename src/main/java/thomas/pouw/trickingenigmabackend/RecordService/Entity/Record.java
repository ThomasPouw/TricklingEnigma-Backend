package thomas.pouw.trickingenigmabackend.RecordService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import springfox.documentation.annotations.ApiIgnore;
import thomas.pouw.trickingenigmabackend.LevelService.Entity.Level;
import thomas.pouw.trickingenigmabackend.UserService.Entity.User;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
@ApiIgnore
@Entity
@Table(name = "Record", schema = "public")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID ID;
    @Column(name="time")
    @NotNull
    private int time;
    @Column(name="turns")
    private int turns;
    @Column(name="record_created")
    @CreationTimestamp
    private Date recordCreated;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "record_user",
            joinColumns =
                    { @JoinColumn(name = "record_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "user_id", referencedColumnName = "id") })//https://www.baeldung.com/jpa-one-to-one
    private User user;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "level_record",
            joinColumns =
                    { @JoinColumn(name = "record_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "level_id", referencedColumnName = "id") })//https://www.baeldung.com/jpa-one-to-one
    private Level level;

    public Record(int times, int turns, Date recordCreated){
        this.time = times;
        this.turns = turns;
        this.recordCreated = recordCreated;
    }
    public Record(int times, int turns){
        this.time = times;
        this.turns = turns;
    }
    public Record() {}

    public Date getRecordCreated() {
        return recordCreated;
    }

    public int getTurns() {
        return turns;
    }

    public int getTime() {
        return time;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID id) {
        ID = id;
    }

    public void setRecordCreated(Date recordCreated) {
        this.recordCreated = recordCreated;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
