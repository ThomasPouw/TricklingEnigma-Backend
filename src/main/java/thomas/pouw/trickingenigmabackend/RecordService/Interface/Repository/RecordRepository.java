package thomas.pouw.trickingenigmabackend.RecordService.Interface.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import thomas.pouw.trickingenigmabackend.RecordService.Entity.Record;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface RecordRepository extends CrudRepository<Record, UUID> {
    //public List<Record> getAllByRecordCreatedBefore(Date RecordCreated);
    List<Record> findRecordsByTurnsLessThanEqual(int turns);
    public Record findRecordByID(@Param("id") UUID id);
    //public Record findRecordByUser_Id(@Param("id") UUID id);
}
