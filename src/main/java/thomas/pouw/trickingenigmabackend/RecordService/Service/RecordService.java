package thomas.pouw.trickingenigmabackend.RecordService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thomas.pouw.trickingenigmabackend.RecordService.Entity.Record;
import thomas.pouw.trickingenigmabackend.RecordService.Interface.Repository.RecordRepository;

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
        return new ArrayList<Record>(recordRepository.findRecordsByTurnsLessThanEqual(turns));
    }
    public Record GetRecordByUserIDAndStageID(UUID UserID){
        return recordRepository.findRecordByID(UserID);
    }
    public List<Record> GetAllRecordsByUserID(UUID UserID){
        List<Record> result = new ArrayList<>();
        return null;
    }
    public List<Record> GetAllRecordsByNationalityAndRecordID(){
        return null;
    }
    public Record saveOrUpdate(Record record){
        recordRepository.save(record);
        return record;
    }
    public Record GetRecordByID(UUID ID){
        return recordRepository.findRecordByID(ID);
    }
}
