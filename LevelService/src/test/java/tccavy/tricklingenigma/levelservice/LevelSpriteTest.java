package tccavy.tricklingenigma.levelservice;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tccavy.tricklingenigma.levelservice.LevelService.Container.LevelContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Container.LevelSpriteContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Level;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.LevelSprite;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Sprite;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LevelSpriteTest {
    /*@Autowired
    private LevelSpriteContainer levelSpriteContainer;
    private LevelSprite levelSprite;
    public LevelSpriteTest(){
        levelSprite = new LevelSprite();
        Sprite sprite = new Sprite();
        sprite.setAssetLocation("/asset/Big-block.png");
        levelSprite.setRotation(2);
        levelSprite.setX(2);
        levelSprite.setY(4);
        levelSprite.setTile_name("End");
        levelSprite.setSprite(sprite);
    }
    @Test
    @Order(1)
    void contextLoads() {
        assertThat(levelSpriteContainer).isNotNull();
    }
    @Test
    @Order(2)
    void PostLevelSprite() {
        LevelSprite levelSprites = levelSpriteContainer.saveLevelSprite(levelSprite);
        levelSprite = levelSprites;
        assertThat(levelSpriteContainer.GetAll()).contains(levelSprite);
    }
    @Test
    @Order(3)
    void UpdateSprite() {
        LevelSprite update = levelSprite;
        LevelSprite oldLevelSprite = levelSpriteContainer.GetAll().get(4);
        update.setRotation(3);
        levelSpriteContainer.updateLevelSprite(update);
        assertThat(levelSpriteContainer.GetAll()).doesNotContain(oldLevelSprite);
    }
    @Test
    @Order(4)
    void GetAllLevels() {
        assertThat(levelSpriteContainer.GetAll()).isNotNull();
    }
    @Test
    @Order(5)
    void deleteLevel() {
        levelSpriteContainer.deleteLevelSprite(levelSprite);
        assertThat(levelSpriteContainer.GetAll()).doesNotContain(levelSprite);
    }*/
}
