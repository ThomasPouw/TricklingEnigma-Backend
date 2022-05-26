package tccavy.tricklingenigma.recordservice;

import tccavy.tricklingenigma.recordservice.RecordService.Entity.Record;

import java.util.Date;
import java.util.UUID;

public class Test_Objects {
    public Record record(){
        Record record = new Record();
        record.setID(UUID.randomUUID());
        record.setLevelID(UUID.randomUUID());
        record.setUserID(UUID.randomUUID());
        record.setTime(536854373);
        record.setRecordCreated(new Date());
        return record;
    }
}
