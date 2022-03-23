package thomas.pouw.trickingenigmabackend.LevelService.Container;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thomas.pouw.trickingenigmabackend.LevelService.Entity.Sprite;
import thomas.pouw.trickingenigmabackend.LevelService.Service.SpriteService;

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
