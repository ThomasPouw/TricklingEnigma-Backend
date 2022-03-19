package thomas.pouw.trickingenigmabackend.UserService.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.UUID;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Nationality {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name="name")
    private String name;
    @Column(name="flag")
    private String flag;

    public void setId(UUID id) {
        this.id = id;
    }
    public void setFlag(String flag) {
        this.flag = flag;
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
    public String getFlag() {
        return flag;
    }
}
