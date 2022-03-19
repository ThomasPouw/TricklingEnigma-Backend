package thomas.pouw.trickingenigmabackend.UserService.Interface.Repository;

import org.springframework.data.repository.CrudRepository;
import thomas.pouw.trickingenigmabackend.UserService.Entity.Nationality;

import java.util.UUID;

public interface NationalityRepository extends CrudRepository<Nationality, UUID> {
}