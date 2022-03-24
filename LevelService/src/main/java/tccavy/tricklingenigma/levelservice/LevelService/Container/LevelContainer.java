package tccavy.tricklingenigma.levelservice.LevelService.Container;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Level;
import tccavy.tricklingenigma.levelservice.LevelService.Service.LevelService;

import java.util.List;
import java.util.UUID;

@Api(description = "Level Controller", tags = { "Level" })
@RestController
@RequestMapping("/Level")
public class LevelContainer {
    @Autowired
    LevelService levelService;
    @GetMapping
    public List<Level> GetAllLevels(){
        return levelService.GetAll();
    }
    public Level GetLevel(@RequestParam UUID id){
        return levelService.GetLevelByID(id);
    }
    @PostMapping
    public Level saveLevel(@RequestBody Level level){
        levelService.saveOrUpdate(level);
        return level;
    }
    @PutMapping
    public Level updateLevel(@RequestBody Level level){
        levelService.saveOrUpdate(level);
        return level;
    }
}
