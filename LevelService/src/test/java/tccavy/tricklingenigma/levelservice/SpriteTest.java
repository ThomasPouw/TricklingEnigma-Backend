package tccavy.tricklingenigma.levelservice;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tccavy.tricklingenigma.levelservice.LevelService.Container.LevelSpriteContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Container.SpriteContainer;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Level;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.LevelSprite;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Sprite;
import tccavy.tricklingenigma.levelservice.LevelService.Interface.Repository.SpriteRepository;
import tccavy.tricklingenigma.levelservice.LevelService.Service.LevelService;
import tccavy.tricklingenigma.levelservice.LevelService.Service.SpriteService;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpriteTest {
    @Autowired
    private SpriteContainer spriteContainer;
    @Mock private SpriteRepository spriteRepository;

    public SpriteTest() {
    }

    @Test
    @Order(1)
    void contextLoads() {
        assertThat(spriteContainer).isNotNull();
    }
    @Test
    @Order(2)
    void PostSprite() {
        Sprite sprite = new Test_Objects().sprite();
        SpriteService spriteService = new SpriteService(spriteRepository);
        Mockito.when(spriteRepository.save(sprite)).thenReturn(sprite);
        var sprite1 = spriteService.saveOrUpdate(sprite);
        assertThat(sprite1).isSameAs(sprite);
    }
    @Test
    @Order(3)
    void UpdateSprite() {
        var sprite = new Test_Objects().sprite();
        SpriteService spriteService= new SpriteService(spriteRepository);
        Mockito.when(spriteRepository.save(sprite)).thenReturn(sprite);
        var sprite1 = spriteRepository.save(sprite);
        assertThat(sprite1).isSameAs(sprite);
        sprite1 = sprite.clone();
        sprite1.setAssetLocation("/asset/plank.png");
        Mockito.when(spriteRepository.save(sprite1)).thenReturn(sprite1);
        assertThat(spriteRepository.save(sprite1).getAssetLocation()).isNotEqualTo(sprite.getAssetLocation());
        assertThat(sprite1).isNotEqualTo(sprite);
    }
    @Test
    @Order(4)
    void GetAllSprites() {
        var sprite = new Test_Objects().sprite();
        var sprite1 = new Test_Objects().sprite();
        SpriteService spriteService = new SpriteService(spriteRepository);
        Mockito.when(spriteRepository.save(sprite)).thenReturn(sprite);
        Mockito.when(spriteRepository.save(sprite1)).thenReturn(sprite1);
        spriteRepository.save(sprite);
        spriteRepository.save(sprite1);
        var list = new ArrayList<Sprite>();
        list.add(sprite1);
        list.add(sprite);
        Mockito.when(spriteRepository.findAll()).thenReturn(list);
        assertThat(spriteRepository.findAll()).isNotNull();
    }
    @Test
    @Order(5)
    void deleteSprite() {
        var sprite = new Test_Objects().sprite();
        var sprite1 = new Test_Objects().sprite();
        SpriteService spriteService = new SpriteService(spriteRepository);
        Mockito.when(spriteRepository.save(sprite)).thenReturn(sprite);
        Mockito.when(spriteRepository.save(sprite1)).thenReturn(sprite1);
        spriteRepository.save(sprite);
        spriteRepository.save(sprite1);
        var list = new ArrayList<>();
        list.add(sprite1);
        SpriteContainer spriteCon = mock(SpriteContainer.class);
        spriteCon.deleteSprite(sprite);
        verify(spriteCon, times(1)).deleteSprite(sprite);
    }
}