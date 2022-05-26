package tccavy.tricklingenigma.levelservice;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tccavy.tricklingenigma.levelservice.LevelService.Container.LevelContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Container.LevelSpriteContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Container.SpriteContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Level;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.LevelSprite;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Sprite;
import tccavy.tricklingenigma.levelservice.LevelService.Interface.Repository.LevelSpriteRepository;
import tccavy.tricklingenigma.levelservice.LevelService.Service.LevelSpriteService;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@RunWith(JUnit4.class)
public class LevelSpriteTest {
    @InjectMocks private DBConnection dbConnection;
    @Mock private Connection mockConnection;
    @Mock private Statement mockStatement;
    @Mock private LevelSpriteRepository levelSpriteRepository;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Autowired
    private LevelSpriteContainer levelSpriteContainer;
    @Autowired
    private SpriteContainer spriteContainer;
    @Autowired
    private LevelContainer levelContainer;
    public LevelSpriteTest(){
    }
    @Test
    @Order(1)
    void contextLoads() {
        assertThat(levelSpriteContainer).isNotNull();
    }
    @Test
    @Order(2)
    void PostLevelSprite() {
        var ls = new Test_Objects().levelSprite();
        LevelSpriteService levelSpriteService = new LevelSpriteService(levelSpriteRepository);
        Mockito.when(levelSpriteRepository.save(ls)).thenReturn(ls);
        var ls2 = levelSpriteRepository.save(ls);
        assertThat(ls2).isSameAs(ls);
    }
    @Test
    @Order(3)
    void UpdateSprite() {
        var ls = new Test_Objects().levelSprite();
        LevelSpriteService levelSpriteService = new LevelSpriteService(levelSpriteRepository);
        Mockito.when(levelSpriteRepository.save(ls)).thenReturn(ls);
        var ls2 = levelSpriteRepository.save(ls);
        assertThat(ls2).isSameAs(ls);
        ls2 = ls.clone();
        ls2.setY(98);
        Mockito.when(levelSpriteRepository.save(ls2)).thenReturn(ls2);
        assertThat(levelSpriteRepository.save(ls2).getY()).isNotEqualTo(ls.getY());

    }
    @Test
    @Order(4)
    void GetAllLevels() {
        var ls = new Test_Objects().levelSprite();
        var ls2 = new Test_Objects().levelSprite();
        LevelSpriteService levelSpriteService = new LevelSpriteService(levelSpriteRepository);
        Mockito.when(levelSpriteRepository.save(ls)).thenReturn(ls);
        Mockito.when(levelSpriteRepository.save(ls2)).thenReturn(ls2);
        levelSpriteRepository.save(ls);
        levelSpriteRepository.save(ls2);
        var list = new ArrayList<LevelSprite>();
        list.add(ls2);
        Mockito.when(levelSpriteRepository.findAll()).thenReturn(list);
        assertThat(levelSpriteRepository.findAll()).isNotNull();
    }
    @Test
    @Order(5)
    void deleteLevel() {
        var ls = new Test_Objects().levelSprite();
        var ls2 = new Test_Objects().levelSprite();
        LevelSpriteService levelSpriteService = new LevelSpriteService(levelSpriteRepository);
        Mockito.when(levelSpriteRepository.save(ls)).thenReturn(ls);
        Mockito.when(levelSpriteRepository.save(ls2)).thenReturn(ls2);
        levelSpriteRepository.save(ls);
        levelSpriteRepository.save(ls2);
        var list = new ArrayList<>();
        list.add(ls2);
        LevelSpriteContainer levelSpriteCon = mock(LevelSpriteContainer.class);
        levelSpriteCon.deleteLevelSprite(ls);
        verify(levelSpriteCon, times(1)).deleteLevelSprite(ls);
    }
}
