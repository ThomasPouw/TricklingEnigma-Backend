package tccavy.tricklingenigma.userservice;

import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tccavy.tricklingenigma.userservice.UserService.Container.NationalityContainer;
import tccavy.tricklingenigma.userservice.UserService.Entity.Nationality;
import tccavy.tricklingenigma.userservice.UserService.Interface.Repository.NationalityRepository;
import tccavy.tricklingenigma.userservice.UserService.Service.NationalityService;

import java.sql.Connection;
import java.sql.Statement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NationalityTest {
    @InjectMocks
    private DBConnection dbConnection;
    @Mock private Connection mockConnection;
    @Mock private Statement mockStatement;
    @Mock
    private NationalityRepository nationalityRepository;
    @Autowired
    private NationalityContainer nationalityContainer;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    public NationalityTest(){
    }
    @Test
    @Order(1)
    void contextLoads() {
        assertThat(nationalityContainer).isNotNull();
    }
    @Test
    @Order(2)
    void PostNationality() {
        var Nationality = new Test_Objects().nationality();
        NationalityService nationalityService = new NationalityService(nationalityRepository);
        Mockito.when(nationalityRepository.save(Nationality)).thenReturn(Nationality);
        var ls2 = nationalityRepository.save(Nationality);
        assertThat(ls2).isSameAs(Nationality);
    }
    @Test
    @Order(3)
    void UpdateNationality() {
        var Nationality = new Test_Objects().nationality();
        NationalityService nationalityService = new NationalityService(nationalityRepository);
        Mockito.when(nationalityRepository.save(Nationality)).thenReturn(Nationality);
        var Nationality2 = nationalityRepository.save(Nationality);
        assertThat(Nationality2).isSameAs(Nationality);
        Nationality2 = Nationality.clone();
        Nationality2.setName("Lorum Ipsum");
        Mockito.when(nationalityRepository.save(Nationality2)).thenReturn(Nationality2);
        assertThat(nationalityRepository.save(Nationality2).getName()).isNotEqualTo(Nationality.getName());
        assertThat(Nationality2).isNotEqualTo(Nationality);
    }
    @Test
    @Order(4)
    public void GetAllNationalities() {
        assertThat(nationalityContainer.GetAll()).isNotNull();
    }
}
