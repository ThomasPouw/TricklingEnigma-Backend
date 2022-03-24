package tccavy.tricklingenigma.levelservice.LevelService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tccavy.tricklingenigma.levelservice.LevelService.Entity.Sprite;
import tccavy.tricklingenigma.levelservice.LevelService.Interface.Repository.SpriteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpriteService {
    @Autowired
    private SpriteRepository spriteRepository;

    public List<Sprite> GetAll(){
        List<Sprite> result = new ArrayList<>();
        spriteRepository.findAll().forEach(result::add);
        return result;
    }
    public void saveOrUpdate(Sprite sprite){
        spriteRepository.save(sprite);
    }
}
