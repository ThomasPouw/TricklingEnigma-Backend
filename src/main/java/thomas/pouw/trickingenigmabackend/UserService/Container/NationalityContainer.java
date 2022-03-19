package thomas.pouw.trickingenigmabackend.UserService.Container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thomas.pouw.trickingenigmabackend.UserService.Entity.Nationality;
import thomas.pouw.trickingenigmabackend.UserService.Interface.Repository.NationalityRepository;
import thomas.pouw.trickingenigmabackend.UserService.Service.NationalityService;

import java.util.List;

@RestController
@RequestMapping("/Nationality")
public class NationalityContainer {
    @Autowired
    private NationalityService nationalityService;

    @GetMapping
    public List<Nationality> GetAll(){
        return nationalityService.GetAll();
    }
    @PostMapping
    public Nationality SaveNationality(@RequestBody Nationality nationality){
        return nationalityService.saveOrUpdate(nationality);
    }
    @PutMapping
    public Nationality UpdateNationality(@RequestBody Nationality nationality){
        return nationalityService.saveOrUpdate(nationality);
    }
}
