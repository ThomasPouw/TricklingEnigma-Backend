package tccavy.tricklingenigma.levelservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.checkerframework.checker.units.qual.A;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tccavy.tricklingenigma.levelservice.LevelService.Container.LevelContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Level;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.LevelSprite;
import tccavy.tricklingenigma.levelservice.LevelService.Interface.Repository.LevelRepository;
import tccavy.tricklingenigma.levelservice.LevelService.Interface.Repository.LevelSpriteRepository;
import tccavy.tricklingenigma.levelservice.LevelService.Service.LevelService;
import tccavy.tricklingenigma.levelservice.LevelService.Service.LevelSpriteService;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LevelTest {
    @InjectMocks
    private DBConnection dbConnection;
    @Mock
    private Connection mockConnection;
    @Mock private Statement mockStatement;
    @Mock private LevelRepository levelRepository;
    @Autowired
    private LevelContainer levelContainer;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    public LevelTest(){
    }
    @Test
    @Order(1)
    void contextLoads() {
        assertThat(levelContainer).isNotNull();
    }
    @Test
    @Order(2)
    void PostLevel() {
        var level = new Test_Objects().level();
        LevelService levelService = new LevelService(levelRepository);
        Mockito.when(levelRepository.save(level)).thenReturn(level);
        var ls2 = levelRepository.save(level);
        assertThat(ls2).isSameAs(level);
    }
    @Test
    @Order(3)
    void UpdateLevel() {
        var level = new Test_Objects().level();
        LevelService leveService = new LevelService(levelRepository);
        Mockito.when(levelRepository.save(level)).thenReturn(level);
        var level2 = levelRepository.save(level);
        assertThat(level2).isSameAs(level);
        level2 = level.clone();
        level2.setName("Lorum Ipsum");
        Mockito.when(levelRepository.save(level2)).thenReturn(level2);
        assertThat(levelRepository.save(level2).getName()).isNotEqualTo(level.getName());
        assertThat(level2).isNotEqualTo(level);
    }
    @Test
    @Order(4)
    void GetAllLevels() {
        assertThat(levelContainer.GetAllLevels()).isNotNull();
    }
    @Test
    @Order(5)
    void GetLevelByID() {
        var level = new Test_Objects().level();
        var level2 = new Test_Objects().level();
        LevelService levelService = new LevelService(levelRepository);
        Mockito.when(levelRepository.save(level)).thenReturn(level);
        Mockito.when(levelRepository.save(level2)).thenReturn(level2);
        levelRepository.save(level);
        levelRepository.save(level2);
        var list = new ArrayList<>();
        list.add(level2);
        Mockito.when(levelRepository.getLevelByID(level.getID())).thenReturn(level);
        var result = levelRepository.getLevelByID(level.getID());
        assertThat(level).isSameAs(result);
    }
    @Test
    @Order(6)
    void deleteLevel() {
        var level = new Test_Objects().level();
        var level2 = new Test_Objects().level();
        LevelService levelService = new LevelService(levelRepository);
        Mockito.when(levelRepository.save(level)).thenReturn(level);
        Mockito.when(levelRepository.save(level2)).thenReturn(level2);
        levelRepository.save(level);
        levelRepository.save(level2);
        var list = new ArrayList<>();
        list.add(level2);
        levelContainer.deleteLevel(level);
        assertThat(levelContainer.GetAllLevels()).doesNotContain(level);
    }
}
