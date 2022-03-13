package thomas.pouw.trickingenigmabackend.RecordService.Entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import thomas.pouw.trickingenigmabackend.UserService.Entity.User;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Record")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

   // public User getUser() {
    //    return user;
   // }

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
