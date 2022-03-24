package tccavy.tricklingenigma.userservice.UserService.Interface.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tccavy.tricklingenigma.userservice.UserService.Entity.User;

import java.util.UUID;
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    public User getUserByName(String name);
}
