package tccavy.tricklingenigma.levelservice.LevelService.Interface.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.LevelSprite;

import java.util.UUID;
@Repository
public interface LevelSpriteRepository extends CrudRepository<LevelSprite, UUID> {

}
