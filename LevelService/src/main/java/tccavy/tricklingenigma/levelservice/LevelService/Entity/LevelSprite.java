package tccavy.tricklingenigma.levelservice.LevelService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.UUID;
@ApiIgnore
@Entity
@Table(name="levelsprite", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class LevelSprite implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID ID;
    @Column(name="x")
    private int X;
    @Column(name="y")
    private int Y;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sprite_id")
    private Sprite sprite;
    @Column(name="tile_name")
    private String tile_name;
    @Column(name="rotation")
    private int rotation;
    @ManyToOne
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    @JsonBackReference
    private Level level;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setID(UUID ID) {this.ID = ID;}
    public void setX(int x) {
        X = x;
    }
    public void setY(int y) {
        Y = y;
    }
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
    public void setTile_name(String tile_name) {
        this.tile_name = tile_name;
    }

    public void setRotation(int rotation) {this.rotation = rotation;}

    public UUID getID() {return ID;}
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }
    public Sprite getSprite() {
        return sprite;
    }
    public String getTile_name() {
        return tile_name;
    }

    public int getRotation() {return rotation;}

    public LevelSprite clone() {
        // Note2: Catch checked exception here so client or subclass doesn't need to.
        LevelSprite result = null;
        try {
            result = (LevelSprite) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Unable to clone.", e);
        }
        return result;
    }
}
