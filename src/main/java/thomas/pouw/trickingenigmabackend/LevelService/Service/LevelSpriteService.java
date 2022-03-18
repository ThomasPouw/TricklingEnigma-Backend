package thomas.pouw.trickingenigmabackend.LevelService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thomas.pouw.trickingenigmabackend.LevelService.Entity.Level;
import thomas.pouw.trickingenigmabackend.LevelService.Entity.LevelSprite;
import thomas.pouw.trickingenigmabackend.LevelService.Interface.Repository.LevelSpriteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LevelSpriteService {
    @Autowired
    private LevelSpriteRepository levelSpriteRepository;

    public List<LevelSprite> GetAll(){
        List<LevelSprite> result = new ArrayList<>();
        levelSpriteRepository.findAll().forEach(result::add);
        return result;
    }
    public void saveOrUpdate(LevelSprite levelSprite){
        levelSpriteRepository.save(levelSprite);
    }

}
