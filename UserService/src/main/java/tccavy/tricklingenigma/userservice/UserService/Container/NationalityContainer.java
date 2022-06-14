package tccavy.tricklingenigma.userservice.UserService.Container;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tccavy.tricklingenigma.userservice.UserService.Entity.Nationality;
import tccavy.tricklingenigma.userservice.UserService.Service.NationalityService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Nationality")
@Api(description = "Nationality Controller", tags = { "Nationality" })
public class NationalityContainer {
    @Autowired
    private NationalityService nationalityService;

    @GetMapping
    public List<Nationality> GetAll(){
        return nationalityService.GetAll();
    }
    @PostMapping
    public Nationality SaveNationality(@RequestBody Nationality nationality){
        System.out.println("test S");
        return nationalityService.saveOrUpdate(nationality);
    }
    @PutMapping
    public Nationality UpdateNationality(@RequestBody Nationality nationality){
        System.out.println("test U");
        return nationalityService.saveOrUpdate(nationality);
    }
}
