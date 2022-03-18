package thomas.pouw.trickingenigmabackend.RecordService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import thomas.pouw.trickingenigmabackend.UserService.Entity.User;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Record", schema = "public")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID ID;
    @Column(name="time")
    @NotNull
    private String time;
    @Column(name="turns")
    private int turns;
    @Column(name="record_created")
    @CreationTimestamp
    private Date record_created;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinTable(name = "record_user",
            joinColumns =
                    { @JoinColumn(name = "record_id", referencedColumnName = "id", nullable = true) },
            inverseJoinColumns =
                    { @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true) })//https://www.baeldung.com/jpa-one-to-one
    private User user;

    public Record(String times, int turns, Date recordCreated){
        this.time = times;
        this.turns = turns;
        this.record_created = recordCreated;
    }
    public Record(String times, int turns){
        this.time = times;
        this.turns = turns;
    }
    public Record() {}

    public Date getRecordCreated() {
        return record_created;
    }

    public int getTurns() {
        return turns;
    }

    public String getTime() {
        return time;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID id) {
        ID = id;
    }

    public void setRecordCreated(Date recordCreated) {
        record_created = recordCreated;
    }

    public void setTime(String time) {
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
}
