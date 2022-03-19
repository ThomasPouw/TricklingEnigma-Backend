package thomas.pouw.trickingenigmabackend.UserService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thomas.pouw.trickingenigmabackend.UserService.Entity.Nationality;
import thomas.pouw.trickingenigmabackend.UserService.Interface.Repository.NationalityRepository;

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
