package tccavy.tricklingenigma.levelservice.LevelService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Level;
import tccavy.tricklingenigma.levelservice.LevelService.Interface.Repository.LevelRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LevelService {
    @Autowired
    private LevelRepository levelRepository;
    public List<Level> GetAll(){
        List<Level> result = new ArrayList<>();
        levelRepository.findAll().forEach(result::add);
        return result;
    }
    public Level GetLevelByID(UUID ID){
        return levelRepository.getLevelByID(ID);
    }
    public void saveOrUpdate(Level level){
        levelRepository.save(level);
    }
}
