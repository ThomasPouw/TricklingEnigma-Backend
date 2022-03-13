package thomas.pouw.trickingenigmabackend.UserService.Interface.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thomas.pouw.trickingenigmabackend.UserService.Entity.User;


import java.util.UUID;
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    public User getUserByName(String name);
}
