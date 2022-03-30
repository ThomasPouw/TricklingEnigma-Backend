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
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID ID;
    @Column(name="name")
    private String name;
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
}
