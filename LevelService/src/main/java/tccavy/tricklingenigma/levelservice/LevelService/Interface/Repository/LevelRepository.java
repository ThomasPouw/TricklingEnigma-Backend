package tccavy.tricklingenigma.levelservice.LevelService.Interface.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Level;

import java.util.List;
import java.util.UUID;

@Repository
public interface LevelRepository extends CrudRepository<Level, UUID> {
    public Level getLevelByID(@Param("id") UUID ID);
    public Level[] getLevelsByIDIn(@Param("id") List<UUID> ID);
}
