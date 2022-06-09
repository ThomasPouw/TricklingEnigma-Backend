package tccavy.tricklingenigma.recordservice.RecordService.Service;

import org.springframework.data.domain.Pageable;
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
    public RecordService(RecordRepository recordRepository){
    this.recordRepository = recordRepository;
    }
    public List<Record> GetAll(){
        List<Record> result = new ArrayList<>();
        recordRepository.findAll().forEach(result::add);
        return result;
    }
    public List<Record> GetRecordsUnderEqualTurns(int turns){
        return recordRepository.findRecordsByTurnsLessThanEqual(turns);
    }
    public List<Record> GetAllRecordsByLevel(UUID level_id){
        return recordRepository.findRecordsByLevelID(level_id);
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
    public List<Record> GetRecordsByUser_ID(UUID user_id){
        return recordRepository.findRecordsByUserID(user_id);
    }
    //public List<Record> GetAllSorted(UUID ID, Pageable pageable){
    //    return recordRepository.findRecordsByLevelID(ID, pageable); //Pageable.ofSize(1).getSortOr(Sort.by(Sort.Direction.ASC, "time"))
   // }
}
