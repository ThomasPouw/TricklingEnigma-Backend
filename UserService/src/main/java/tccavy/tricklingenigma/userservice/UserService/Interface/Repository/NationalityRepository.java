package tccavy.tricklingenigma.userservice.UserService.Interface.Repository;

import org.springframework.data.repository.CrudRepository;
import tccavy.tricklingenigma.userservice.UserService.Entity.Nationality;

import java.util.UUID;

public interface NationalityRepository extends CrudRepository<Nationality, UUID> {
}