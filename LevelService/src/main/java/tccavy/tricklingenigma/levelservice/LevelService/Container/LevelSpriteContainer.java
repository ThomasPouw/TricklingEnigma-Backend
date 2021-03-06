package tccavy.tricklingenigma.levelservice.LevelService.Container;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.LevelSprite;
import tccavy.tricklingenigma.levelservice.LevelService.Service.LevelSpriteService;

import java.util.List;

@Api(description = "LevelSprite Controller", tags = { "LevelSprite" })
@RestController
@RequestMapping("/LevelSprite")
public class LevelSpriteContainer {
    @Autowired
    private LevelSpriteService levelSpriteService;

    @PostMapping
    public LevelSprite saveLevelSprite(@RequestBody LevelSprite levelSprite){
        levelSpriteService.saveOrUpdate(levelSprite);
        return levelSprite;
    }
    @PutMapping
    public LevelSprite updateLevelSprite(@RequestBody LevelSprite levelSprite){
        levelSpriteService.saveOrUpdate(levelSprite);
        return levelSprite;
    }
    @GetMapping
    public List<LevelSprite> GetAll(){
        return levelSpriteService.GetAll();
    }
    @DeleteMapping
    public void deleteLevelSprite(LevelSprite levelSprite){
        levelSpriteService.delete(levelSprite);
    }
}
