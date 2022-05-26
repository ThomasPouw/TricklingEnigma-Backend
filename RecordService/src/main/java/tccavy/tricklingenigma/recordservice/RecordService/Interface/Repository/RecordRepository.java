package tccavy.tricklingenigma.recordservice.RecordService.Interface.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tccavy.tricklingenigma.recordservice.RecordService.Entity.Record;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecordRepository extends CrudRepository<Record, UUID> {
    //public List<Record> getAllByRecordCreatedBefore(Date RecordCreated);
    List<Record> findRecordsByTurnsLessThanEqual(int turns);
    public Record findRecordByID(@Param("id") UUID id);
    public List<Record> findRecordsByUserIDOrderByRecordCreated(UUID user_id);
    public Record findFirstByUserIDAndLevelIDOrderByTurnsAscTimeAsc(UUID user_id, UUID level_id);
    public List<Record> findAllBy(Pageable pageable);
    public List<Record> findRecordsByLevelID(UUID levelID);

}
