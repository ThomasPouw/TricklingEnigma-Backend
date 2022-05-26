package tccavy.tricklingenigma.levelservice.LevelService.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@ApiIgnore
@Entity
@Table(name="level", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Level implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID ID;
    @Column(name="name")
    private String name;
    @Column(name="x_length")
    private int x_length;
    @Column(name="y_length")
    private int y_length;
    @OneToMany(mappedBy = "level")
    @JsonManagedReference
    private List<LevelSprite> levelSprite;

    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id" )
    //@OneToMany(cascade = CascadeType.ALL, mappedBy="level")//https://www.baeldung.com/jpa-one-to-one
    //private List<Record> records;

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX_length(int x_length) {this.x_length = x_length;}

    public void setY_length(int y_length) {this.y_length = y_length;}

    public void setLevelSprite(List<LevelSprite> levelSprite) {
        this.levelSprite= levelSprite;
    }

    public List<LevelSprite> getLevelSprite() {
        return levelSprite;
    }

    public UUID getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getX_length() {return x_length;}

    public int getY_length() {return y_length;}

    public Level clone() {
        // Note2: Catch checked exception here so client or subclass doesn't need to.
        Level result = null;
        try {
            result = (Level) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Unable to clone.", e);
        }
        return result;
    }
}
