package tccavy.tricklingenigma.levelservice;

import org.springframework.beans.factory.annotation.Autowired;
import tccavy.tricklingenigma.levelservice.LevelService.Container.LevelContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Container.LevelSpriteContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Container.SpriteContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Level;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.LevelSprite;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Sprite;

import java.util.ArrayList;
import java.util.UUID;

public class Test_Objects {
    @Autowired
    private LevelSpriteContainer levelSpriteContainer;
    @Autowired
    private SpriteContainer spriteContainer;
    @Autowired
    private LevelContainer levelContainer;
    public LevelSprite levelSprite(){
        spriteContainer = new SpriteContainer();
        levelContainer = new LevelContainer();
        LevelSprite levelSprite = new LevelSprite();
        levelSprite.setID(UUID.randomUUID());
        levelSprite.setRotation(2);
        levelSprite.setX(2);
        levelSprite.setY(4);
        levelSprite.setTile_name("End");
        Sprite sprite = new Sprite();
        levelSprite.setSprite(sprite);
        Level level = new Level();
        levelSprite.setLevel(level);
        return levelSprite;
    }
    public Level level(){
        Level level = new Level();
        level.setID(UUID.randomUUID());
        level.setName("testy");
        level.setX_length(8);
        level.setY_length(4);
        level.setLevelSprite(new ArrayList<>());
        return level;
    }
    public Sprite sprite(){
        Sprite sprite = new Sprite();
        sprite.setID(UUID.randomUUID());
        sprite.setAssetLocation("/img/plank.png");
        return sprite;
    }
}
