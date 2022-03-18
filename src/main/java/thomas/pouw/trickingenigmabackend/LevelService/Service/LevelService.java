package thomas.pouw.trickingenigmabackend.LevelService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thomas.pouw.trickingenigmabackend.LevelService.Entity.Level;
import thomas.pouw.trickingenigmabackend.LevelService.Interface.Repository.LevelRepository;
import thomas.pouw.trickingenigmabackend.RecordService.Entity.Record;

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
