package tccavy.tricklingenigma.levelservice.LevelService.Interface.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Sprite;

import java.util.UUID;
@Repository
public interface SpriteRepository extends CrudRepository<Sprite, UUID> {
}
