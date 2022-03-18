package thomas.pouw.trickingenigmabackend.UserService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thomas.pouw.trickingenigmabackend.RecordService.Entity.Record;
import thomas.pouw.trickingenigmabackend.UserService.Entity.User;
import thomas.pouw.trickingenigmabackend.UserService.Interface.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User saveOrUpdate(User user){
        userRepository.save(user);
        return user;
    }
    public List<User> GetAll(){
        List<User> result = new ArrayList<>();
        userRepository.findAll().forEach(result::add);
        return result;
    }
}
