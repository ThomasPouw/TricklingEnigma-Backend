package tccavy.tricklingenigma.userservice;


import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tccavy.tricklingenigma.userservice.UserService.Container.UserContainer;
import tccavy.tricklingenigma.userservice.UserService.Entity.User;
import tccavy.tricklingenigma.userservice.UserService.Interface.Repository.UserRepository;
import tccavy.tricklingenigma.userservice.UserService.Service.UserService;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {
    @Mock
    private tccavy.tricklingenigma.userservice.UserService.Interface.Repository.UserRepository UserRepository;
    @Autowired
    private UserContainer userContainer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    public UserTest(){
    }
    @Test
    @Order(1)
    void contextLoads() {
        assertThat(userContainer).isNotNull();
    }
    @Test
    @Order(2)
    void PostUser() {
        var user = new Test_Objects().user();
        UserService userService = new UserService(UserRepository);
        Mockito.when(UserRepository.save(user)).thenReturn(user);
        var user1 = UserRepository.save(user);
        assertThat(user1).isSameAs(user);
    }
    @Test
    @Order(3)
    void UpdateUser() {
        var User = new Test_Objects().user();
        UserService leveService = new UserService(UserRepository);
        Mockito.when(UserRepository.save(User)).thenReturn(User);
        var User2 = UserRepository.save(User);
        assertThat(User2).isSameAs(User);
        User2 = User.clone();
        User2.setName("Lorum Ipsum");
        Mockito.when(UserRepository.save(User2)).thenReturn(User2);
        assertThat(UserRepository.save(User2).getName()).isNotEqualTo(User.getName());
        assertThat(User2).isNotEqualTo(User);
    }
    @Test
    @Order(4)
    void GetAllUsers() {
        var User = new Test_Objects().user();
        var User2 = new Test_Objects().user();
        UserService UserService = new UserService(UserRepository);
        Mockito.when(UserRepository.save(User)).thenReturn(User);
        Mockito.when(UserRepository.save(User2)).thenReturn(User2);
        UserRepository.save(User);
        UserRepository.save(User2);
        var list = new ArrayList<User>();
        list.add(User);
        list.add(User2);
        Mockito.when(UserRepository.findAll()).thenReturn(list);
        assertThat(UserRepository.findAll()).isNotNull();
    }
    @Test
    @Order(5)
    void GetUserByID() {
        var User = new Test_Objects().user();
        var User2 = new Test_Objects().user();
        UserService UserService = new UserService(UserRepository);
        Mockito.when(UserRepository.save(User)).thenReturn(User);
        Mockito.when(UserRepository.save(User2)).thenReturn(User2);
        UserRepository.save(User);
        UserRepository.save(User2);
        var list = new ArrayList<>();
        list.add(User2);
        Mockito.when(UserRepository.getUserById(User.getId())).thenReturn(User);
        var result = UserRepository.getUserById(User.getId());
        assertThat(User).isSameAs(result);
    }
    @Test
    @Order(5)
    void GetUserBySecret() {
        var User = new Test_Objects().user();
        var User2 = new Test_Objects().user();
        UserService UserService = new UserService(UserRepository);
        Mockito.when(UserRepository.save(User)).thenReturn(User);
        Mockito.when(UserRepository.save(User2)).thenReturn(User2);
        UserRepository.save(User);
        UserRepository.save(User2);
        var list = new ArrayList<>();
        list.add(User2);
        Mockito.when(UserRepository.getUserBySecret(User.getSecret())).thenReturn(User);
        var result = UserRepository.getUserBySecret(User.getSecret());
        assertThat(User).isSameAs(result);
    }
}
