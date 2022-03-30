package tccavy.tricklingenigma.levelservice.LevelService.Container;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Sprite;
import tccavy.tricklingenigma.levelservice.LevelService.Service.SpriteService;

import java.util.List;

@Api(description = "Sprite Controller", tags = { "Sprite" })
@RestController
@RequestMapping("/Sprite")
public class SpriteContainer {
    @Autowired
    private SpriteService spriteService;
    @PostMapping
    public Sprite saveSprite(@RequestBody Sprite sprite){
        spriteService.saveOrUpdate(sprite);
        return sprite;
    }
    @PutMapping
    public Sprite updateSprite(@RequestBody Sprite sprite){
        spriteService.saveOrUpdate(sprite);
        return sprite;
    }
    @GetMapping
    public List<Sprite> getAll(){
        return spriteService.GetAll();
    }
}
