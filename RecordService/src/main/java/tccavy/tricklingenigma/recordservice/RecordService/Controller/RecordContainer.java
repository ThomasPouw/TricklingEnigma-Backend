package tccavy.tricklingenigma.recordservice.RecordService.Controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import tccavy.tricklingenigma.recordservice.RecordService.Entity.Record;
import tccavy.tricklingenigma.recordservice.RecordService.Service.RecordService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Records")
@Api(description = "Record Controller", tags = { "Record" })
public class RecordContainer {
    @Autowired
    RecordService recordService;
    @GetMapping
    public List<Record> GetAll(){
        return recordService.GetAll();
    }
    @GetMapping("{Record_ID}")
    public Record GetRecord(@PathVariable("Record_ID") UUID Record_ID){
        return recordService.GetRecordByID(Record_ID);
    }

    @GetMapping("/UnderTurns/{turns}")
    public List<Record> GetAllUnderTurns(@PathVariable("turns") int turns){
        return recordService.GetRecordsUnderEqualTurns(turns);
    }
    @GetMapping("/Level/User")
    public Record GetRecordFromUserAndLevel(@RequestParam("Level_ID") UUID level_id, @RequestParam("User_ID") UUID user_id){
        return recordService.GetAllRecordsByUserAndLevel(user_id, level_id);
    }
    @GetMapping("/Level")
    public List<Record> GetRecordsFromLevel(@RequestParam("Level_ID") UUID level_id){
        return recordService.GetAllRecordsByLevel(level_id);
    }
    @GetMapping("/User")
    public List<Record> GetAllRecordsFromUser(@RequestParam("User_ID") UUID User_ID){
        return recordService.GetRecordsByUser_ID(User_ID);
    }
    @PostMapping
    public Record saveNewRecord(@RequestBody Record record){
        recordService.saveOrUpdate(record);
        return record;
    }
    @PutMapping
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
