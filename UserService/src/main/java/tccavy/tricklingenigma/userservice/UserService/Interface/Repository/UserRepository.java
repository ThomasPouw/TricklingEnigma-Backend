package tccavy.tricklingenigma.userservice.UserService.Interface.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tccavy.tricklingenigma.userservice.UserService.Entity.User;

import java.util.List;
import java.util.UUID;
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    public User getUserByName(String name);
    public List<User> getUsersByNationality_Id(UUID nationality_Id);
    public User getUserById(UUID ID);
    public List<User> getUsersBy(Pageable pageable);
}
