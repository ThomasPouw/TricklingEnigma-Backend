package tccavy.tricklingenigma.levelservice.LevelService.Container;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('read:Level')")
    public List<Level> GetAllLevels(){
        return levelService.GetAll();
    }
    @GetMapping("/Single")
    @PreAuthorize("hasAuthority('read:Level')")
    public Level GetLevelByID(@RequestParam String id){
        return levelService.GetLevelByID(UUID.fromString(id));
    }
    @GetMapping("/Record")
    public Level[] GetLevelByID(@RequestParam("levelIDs") String[] levelIDs){
        return levelService.GetLevelsByID(levelIDs);
    }
    @PostMapping
    @PreAuthorize("hasAuthority('save:Level')")
    public Level saveLevel(@RequestBody Level level){
        return levelService.saveOrUpdate(level);
    }
    @PutMapping
    @PreAuthorize("hasAuthority('update:Level')")
    public Level updateLevel(@RequestBody Level level){
        return levelService.saveOrUpdate(level);
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('delete:Level')")
    public Level deleteLevel(@RequestBody Level level){
        levelService.delete(level);
        return level;
    }
}
