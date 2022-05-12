package tccavy.tricklingenigma.levelservice;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tccavy.tricklingenigma.levelservice.LevelService.Container.LevelSpriteContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Container.SpriteContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Level;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.LevelSprite;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Sprite;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpriteTest {
   /* @Autowired
    private SpriteContainer spriteContainer;
    private Sprite sprite;

    public SpriteTest() {
        sprite = new Sprite();
        sprite.setAssetLocation("/img/plank.png");
    }

    @Test
    @Order(1)
    void contextLoads() {
        assertThat(spriteContainer).isNotNull();
    }
    @Test
    @Order(2)
    void PostSprite() {
        Sprite sprite1 = spriteContainer.saveSprite(sprite);
        sprite = sprite1;
        assertThat(spriteContainer.getAll()).contains(sprite);
    }
    @Test
    @Order(3)
    void UpdateSprite() {
        Sprite update = sprite;
        Sprite oldLevel = spriteContainer.getAll().get(1);
        update.setAssetLocation("/asset/plank.png");
        spriteContainer.updateSprite(update);
        assertThat(spriteContainer.getAll()).doesNotContain(oldLevel);
    }
    @Test
    @Order(4)
    void GetAllLevels() {
        assertThat(spriteContainer.getAll()).isNotNull();
    }
    @Test
    @Order(5)
    void deleteLevel() {
        spriteContainer.deleteSprite(sprite);
        assertThat(spriteContainer.getAll()).doesNotContain(sprite);
    }*/
}