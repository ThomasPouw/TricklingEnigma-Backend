package tccavy.tricklingenigma.levelservice.LevelService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.LevelSprite;
import tccavy.tricklingenigma.levelservice.LevelService.Interface.Repository.LevelSpriteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LevelSpriteService {
    @Autowired
    private LevelSpriteRepository levelSpriteRepository;
    public LevelSpriteService(LevelSpriteRepository levelSpriteRepositorytest){
        this.levelSpriteRepository = levelSpriteRepositorytest;
    }
    public List<LevelSprite> GetAll(){
        List<LevelSprite> result = new ArrayList<>();
        levelSpriteRepository.findAll().forEach(result::add);
        return result;
    }
    public void saveOrUpdate(LevelSprite levelSprite){
        levelSpriteRepository.save(levelSprite);
    }
    public void delete(LevelSprite levelSprite){
        levelSpriteRepository.delete(levelSprite);
    }

}
