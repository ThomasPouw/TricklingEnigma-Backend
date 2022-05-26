package tccavy.tricklingenigma.levelservice.LevelService.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.UUID;
@ApiIgnore
@Entity
@Table(name="sprite", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sprite implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID ID;
    @Column(name="asset_location")
    private String assetLocation;
    public Sprite() {}

    public void setID(UUID ID) {this.ID = ID;}
    public void setAssetLocation(String assetLocation) {this.assetLocation = assetLocation;}

    public UUID getID() {return ID;}
    public String getAssetLocation() {return assetLocation;}
    public Sprite clone() {
        // Note2: Catch checked exception here so client or subclass doesn't need to.
        Sprite result = null;
        try {
            result = (Sprite) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Unable to clone.", e);
        }
        return result;
    }
}
