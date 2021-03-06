package tccavy.tricklingenigma.userservice.UserService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tccavy.tricklingenigma.userservice.UserService.Entity.User;
import tccavy.tricklingenigma.userservice.UserService.Interface.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User saveOrUpdate(User user){
        userRepository.save(user);
        return user;
    }
    public List<User> GetAll(){
        List<User> result = new ArrayList<>();
        userRepository.findAll().forEach(result::add);
        return result;
    }
    public List<User> GetUsersByNationality(UUID ID){
        return userRepository.getUsersByNationality_Id(ID);
    }
    public List<User> GetUsersByUserIDs(String[] ID){
        List<UUID> UId = new ArrayList<>();
        for(int i = 0; i < ID.length; i++){
            UId.add(UUID.fromString(ID[i]));
        }

        return userRepository.getUsersByIdIn(UId);
    }
    public List<User> GetUsersByUserIDsAndNationalityID(String[] ID, String nationality_ID){
        List<UUID> UId = new ArrayList<>();
        for(int i = 0; i < ID.length; i++){
            UId.add(UUID.fromString(ID[i]));
        }

        return userRepository.getUsersByIdInAndAndNationality_Id(UId, UUID.fromString(nationality_ID));
    }
    public User GetUserByID(UUID ID){
        return userRepository.getUserById(ID);
    }
    public User GetUserBySub(String ID){
        return userRepository.getUserBySecret(ID);
    }
}
