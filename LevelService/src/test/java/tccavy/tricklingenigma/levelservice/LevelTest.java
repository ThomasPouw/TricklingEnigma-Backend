package tccavy.tricklingenigma.levelservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tccavy.tricklingenigma.levelservice.LevelService.Container.LevelContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Level;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.LevelSprite;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LevelTest {

   /* @Autowired
    private LevelContainer levelContainer;
    private Level level;
    public LevelTest(){
        level = new Level();
        level.setName("testy");
        level.setX_length(8);
        level.setY_length(4);
        level.setLevelSprite(new ArrayList<>());
    }
    @Test
    @Order(1)
    void contextLoads() {
        assertThat(levelContainer).isNotNull();
    }
    @Test
    @Order(2)
    void PostLevel() {
        this.level = levelContainer.saveLevel(level);
        assertThat(levelContainer.GetLevelByID(this.level.getID())).isNotNull().isIn(this.level);
    }
    @Test
    @Order(3)
    void UpdateLevel() {
        Level update = level;
        Level oldLevel = levelContainer.GetLevelByID(update.getID());
        update.setY_length(9);
        Level levels = levelContainer.updateLevel(update);
        assertThat(levelContainer.GetLevelByID(levels.getID())).isNotEqualTo(oldLevel);
    }
    @Test
    @Order(4)
    void GetAllLevels() {
        assertThat(levelContainer.GetAllLevels()).isNotNull();
    }
    @Test
    @Order(5)
    void GetLevelByID() {
        System.out.println(level);
        assertThat(levelContainer.GetLevelByID(level.getID())).isNotNull();
    }
    @Test
    @Order(6)
    void deleteLevel() {
        levelContainer.deleteLevel(level);
        assertThat(levelContainer.GetLevelByID(level.getID())).isNull();
    }*/
}
