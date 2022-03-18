package thomas.pouw.trickingenigmabackend.LevelService.Interface.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import thomas.pouw.trickingenigmabackend.LevelService.Entity.Sprite;

import java.util.UUID;
@Repository
public interface SpriteRepository extends CrudRepository<Sprite, UUID> {
}
