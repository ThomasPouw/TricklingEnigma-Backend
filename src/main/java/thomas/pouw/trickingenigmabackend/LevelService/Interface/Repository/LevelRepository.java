package thomas.pouw.trickingenigmabackend.LevelService.Interface.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import thomas.pouw.trickingenigmabackend.LevelService.Entity.Level;

import java.util.UUID;

@Repository
public interface LevelRepository extends CrudRepository<Level, UUID> {
    public Level getLevelByID(@Param("id") UUID ID);
}
