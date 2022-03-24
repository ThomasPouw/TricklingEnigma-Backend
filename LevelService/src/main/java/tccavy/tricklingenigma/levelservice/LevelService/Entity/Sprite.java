package tccavy.tricklingenigma.levelservice.LevelService.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.UUID;
@ApiIgnore
@Entity
@Table(name="sprite", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sprite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID ID;
    @Column(name="asset_location")
    private String assetLocation;
    @Column(name="rotation")
    private int rotation;
    public Sprite() {}

    public void setID(UUID ID) {this.ID = ID;}
    public void setAssetLocation(String assetLocation) {this.assetLocation = assetLocation;}
    public void setRotation(int rotation) {this.rotation = rotation;}

    public UUID getID() {return ID;}
    public String getAssetLocation() {return assetLocation;}
    public int getRotation() {return rotation;}
}
