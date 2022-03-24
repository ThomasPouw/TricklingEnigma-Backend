package tccavy.tricklingenigma.userservice.UserService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tccavy.tricklingenigma.userservice.UserService.Entity.Nationality;
import tccavy.tricklingenigma.userservice.UserService.Interface.Repository.NationalityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NationalityService {
    @Autowired
    private NationalityRepository nationalityRepository;
    public Nationality saveOrUpdate(Nationality nationality){
        nationalityRepository.save(nationality);
        return nationality;
    }
    public List<Nationality> GetAll(){
        List<Nationality> result = new ArrayList<>();
        nationalityRepository.findAll().forEach(result::add);
        return result;
    }
}
