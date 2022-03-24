package tccavy.tricklingenigma.recordservice.RecordService.Service;

import tccavy.tricklingenigma.recordservice.RecordService.Entity.Record;
import tccavy.tricklingenigma.recordservice.RecordService.Interface.Repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;

    public List<Record> GetAll(){
        List<Record> result = new ArrayList<>();
        recordRepository.findAll().forEach(result::add);
        return result;
    }
    public List<Record> GetRecordsUnderEqualTurns(int turns){
        return recordRepository.findRecordsByTurnsLessThanEqual(turns);
    }
    public List<Record> GetAllRecordsByLevelAndNationality(UUID level_id, UUID nationality_id){
        return null; //recordRepository.findRecordsByLevel_IDAndUser_Nationality_IdOrderByTimeAscTurnsAsc(level_id, nationality_id);
    }
    public Record saveOrUpdate(Record record){
        recordRepository.save(record);
        return record;
    }
    public Record GetRecordByID(UUID ID){
        return recordRepository.findRecordByID(ID);
    }
    public Record GetAllRecordsByUserAndLevel(UUID user_id, UUID level_id){
        return recordRepository.findFirstByUserIDAndLevelIDOrderByTurnsAscTimeAsc(user_id, level_id); //This is the Personal record board thingy...
    }
    public List<Record> GetRecordsByUser_IDAndOrderedByRecordCreated(UUID user_id){
        return recordRepository.findRecordsByUserIDOrderByRecordCreated(user_id);
    }
    public List<Record> GetAllOrderedByTurns(){
        return recordRepository.findAllBy(PageRequest.of(0,6, Sort.by(Sort.Direction.ASC, "turns")));
    }
    public List<Record> GetAllOrderedByTime(){
        return recordRepository.findAllBy(PageRequest.of(0,6, Sort.by(Sort.Direction.ASC, "time"))); //Pageable.ofSize(1).getSortOr(Sort.by(Sort.Direction.ASC, "time"))
    }
}
