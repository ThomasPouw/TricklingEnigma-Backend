package tccavy.tricklingenigma.recordservice.RecordService.Entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
@ApiIgnore
@Entity
@Table(name = "Record", schema = "public")
public class Record implements Cloneable{
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
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinTable(name = "record_user",
    //        joinColumns =
    //                { @JoinColumn(name = "record_id", referencedColumnName = "id") },
    //        inverseJoinColumns =
     //               { @JoinColumn(name = "user_id", referencedColumnName = "id") })//https://www.baeldung.com/jpa-one-to-one
    @Column(name="user_id")
    private UUID userID;
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    //@ManyToOne(fetch = FetchType.LAZY)
   // @JoinTable(name = "level_record",
    //        joinColumns =
    //                { @JoinColumn(name = "record_id", referencedColumnName = "id") },
    //        inverseJoinColumns =
    //                { @JoinColumn(name = "level_id", referencedColumnName = "id") })//https://www.baeldung.com/jpa-one-to-one
    @Column(name="level_id")
    private UUID levelID;

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

    public UUID getLevelID() {return levelID;}

    public UUID getUserID() {return userID;}

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

    public void setLevelID(UUID level_id) {this.levelID = level_id;}

    public void setUserID(UUID user_id) {this.userID = user_id;}

    public Record clone() {
        // Note2: Catch checked exception here so client or subclass doesn't need to.
        Record result = null;
        try {
            result = (Record) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Unable to clone.", e);
        }
        return result;
    }
}
