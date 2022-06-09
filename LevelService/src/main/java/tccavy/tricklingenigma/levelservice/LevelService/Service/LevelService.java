package tccavy.tricklingenigma.levelservice.LevelService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Level;
import tccavy.tricklingenigma.levelservice.LevelService.Interface.Repository.LevelRepository;
import tccavy.tricklingenigma.levelservice.LevelService.Interface.Repository.LevelSpriteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LevelService {
    @Autowired
    private LevelRepository levelRepository;
    public LevelService(LevelRepository levelRepositorytest){
        this.levelRepository = levelRepositorytest;
    }
    public List<Level> GetAll(){
        List<Level> result = new ArrayList<>();
        levelRepository.findAll().forEach(result::add);
        return result;
    }
    public Level GetLevelByID(UUID ID){
        return levelRepository.getLevelByID(ID);
    }
    public Level[] GetLevelsByID(String[] IDs){
        List<UUID> levelIDs = new ArrayList<>();
        for (var ID: IDs) {
            levelIDs.add(UUID.fromString(ID));
        }
        return levelRepository.getLevelsByIDIn(levelIDs);
    }
    public Level saveOrUpdate(Level level){
        return levelRepository.save(level);
    }
    public void delete(Level level){
        levelRepository.delete(level);
    }
}
