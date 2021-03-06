package tccavy.tricklingenigma.userservice.UserService.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.UUID;

@ApiIgnore
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Nationality implements Cloneable{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name="name")
    private String name;

    public void setId(UUID id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Nationality clone() {
        // Note2: Catch checked exception here so client or subclass doesn't need to.
        Nationality result = null;
        try {
            result = (Nationality) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Unable to clone.", e);
        }
        return result;
    }
}
