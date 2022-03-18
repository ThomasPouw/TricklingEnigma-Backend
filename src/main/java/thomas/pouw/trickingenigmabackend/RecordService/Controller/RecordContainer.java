package thomas.pouw.trickingenigmabackend.RecordService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thomas.pouw.trickingenigmabackend.RecordService.Entity.Record;
import thomas.pouw.trickingenigmabackend.RecordService.Interface.Repository.RecordRepository;
import thomas.pouw.trickingenigmabackend.RecordService.Service.RecordService;
import thomas.pouw.trickingenigmabackend.UserService.Entity.User;
import thomas.pouw.trickingenigmabackend.UserService.Interface.Repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Records")
public class RecordContainer {
    @Autowired
    RecordService recordService;
    @GetMapping("/")
    public List<Record> GetAll(){
        return recordService.GetAll();
    }
    @GetMapping("/UnderTurns/{turns}")
    public List<Record> GetAllUnderTurns(@PathVariable("turns") int turns){
        return recordService.GetRecordsUnderEqualTurns(turns);
    }
    @GetMapping("/User")
    public Record GetUserRecordOfStage(){
        return recordService.GetRecordByUserIDAndStageID(UUID.fromString("b2323337-da9a-4b3c-a719-2d3597d88278"));
    }
    @PostMapping(value="/")
    public Record saveNewRecord(@RequestBody Record record){
        recordService.saveOrUpdate(record);
        return record;
    }
    @PutMapping(value="/")
    public Record updateRecord(@RequestBody Record record){
        recordService.saveOrUpdate(record);
        return record;
    }
    /*@GetMapping("/User")
    public List<Record> GetRecordByUserAndStage(){
        List<Record> result = new ArrayList<Record>();
        userRepository.save(new User("thomas", "thomas.pouww@gmail.com"));
        User u = userRepository.getUserByName("thomas");
        recordRepository.save(new Record("1:23", 5, new Date()));
        recordRepository.findAll().forEach(result::add);
        return result;
    }*/
}
