package thomas.pouw.trickingenigmabackend.UserService.Container;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thomas.pouw.trickingenigmabackend.UserService.Entity.User;
import thomas.pouw.trickingenigmabackend.UserService.Service.UserService;

import java.util.List;

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
}
