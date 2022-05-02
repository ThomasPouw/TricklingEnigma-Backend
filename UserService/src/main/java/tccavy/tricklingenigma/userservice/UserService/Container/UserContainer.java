package tccavy.tricklingenigma.userservice.UserService.Container;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tccavy.tricklingenigma.userservice.UserService.Entity.User;
import tccavy.tricklingenigma.userservice.UserService.Service.UserService;

import java.util.List;
import java.util.UUID;

@Api(description = "User Controller", tags = { "User" })
@RestController
@RequestMapping("/User")
public class UserContainer {
    @Autowired
    private UserService userService;
    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
    @GetMapping
    public List<User> GetAllUsers(){
        return userService.GetAll();
    }
    @GetMapping("/S")
    public User GetUserByID(@RequestParam String secret){
        return userService.GetUserBySub(secret);
    }
    @GetMapping("/Nationality")
    public List<User> GetUsersByNationality(@RequestParam("nationality_ID") UUID nationality_Id){
        return userService.GetUsersByNationality(nationality_Id);
    }
}
