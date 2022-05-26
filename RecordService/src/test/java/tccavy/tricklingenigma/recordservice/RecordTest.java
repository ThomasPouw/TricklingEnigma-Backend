package tccavy.tricklingenigma.recordservice;

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
import tccavy.tricklingenigma.recordservice.RecordService.Controller.RecordContainer;
import tccavy.tricklingenigma.recordservice.RecordService.Interface.Repository.RecordRepository;
import tccavy.tricklingenigma.recordservice.RecordService.Service.RecordService;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RecordTest {
    @Mock
    private RecordRepository recordRepository;
    @Autowired
    private RecordContainer recordContainer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    public RecordTest(){
    }
    @Test
    @Order(1)
    void contextLoads() {
        assertThat(recordContainer).isNotNull();
    }
    @Test
    @Order(2)
    void PostRecord() {
        var record = new Test_Objects().record();
        RecordService recordService = new RecordService(recordRepository);
        Mockito.when(recordRepository.save(record)).thenReturn(record);
        var ls2 = recordRepository.save(record);
        assertThat(ls2).isSameAs(record);
    }
    @Test
    @Order(3)
    void UpdateRecord() {
        var record = new Test_Objects().record();
        RecordService recordService = new RecordService(recordRepository);
        Mockito.when(recordRepository.save(record)).thenReturn(record);
        var record1 = recordRepository.save(record);
        assertThat(record1).isSameAs(record);
        record1 = record.clone();
        record1.setTime(364737);
        Mockito.when(recordRepository.save(record1)).thenReturn(record);
        assertThat(recordRepository.save(record1).getTime()).isNotEqualTo(record.getTime());
        assertThat(record1).isNotEqualTo(record);
    }
    @Test
    @Order(4)
    void GetAllRecords() {
        assertThat(recordContainer.GetAll()).isNotNull();
    }
    @Test
    @Order(5)
    void GetLevelByID() {
        var record = new Test_Objects().record();
        var record1 = new Test_Objects().record();
        RecordService recordService = new RecordService(recordRepository);
        Mockito.when(recordRepository.save(record)).thenReturn(record);
        Mockito.when(recordRepository.save(record1)).thenReturn(record1);
        recordRepository.save(record);
        recordRepository.save(record1);
        var list = new ArrayList<>();
        list.add(record1);
        Mockito.when(recordRepository.findRecordByID(record.getID())).thenReturn(record);
        var result = recordRepository.findRecordByID(record.getID());
        assertThat(record).isSameAs(result);
    }
}
