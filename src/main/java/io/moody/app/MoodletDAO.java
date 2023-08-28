package io.moody.app;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class MoodletDAO implements IDataAccessObject<Moodlet> {

    public boolean createRecord(Moodlet data) {
        boolean success = false;
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO moodlet (moodlet_id, name, ) VALUES (?, ?, ?)";
            


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
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
