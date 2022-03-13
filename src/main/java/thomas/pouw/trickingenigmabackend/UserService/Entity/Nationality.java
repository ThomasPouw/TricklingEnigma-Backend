package thomas.pouw.trickingenigmabackend.UserService.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Nationality {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name="name")
    private String name;
    @Column(name="flag")
    private String flag;

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getFlag() {
        return flag;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    public void setName(String name) {
        this.name = name;
    }
}
