package io.moody.app;
import java.sql.*;
import java.util.*;

public class MoodletDAO implements IDataAccessObject<Moodlet> {

    public boolean createRecord(Moodlet data) {
        return false;
    }

    public Moodlet readRecord(long id) {
        return new Moodlet();
    }

    public boolean updateRecord(Moodlet data) {
        return false;
    }

    public boolean deleteRecord(long id) {
        return false;
    }

    public List<Moodlet> getAllRecords() {
        return new ArrayList<>();
    }
}
