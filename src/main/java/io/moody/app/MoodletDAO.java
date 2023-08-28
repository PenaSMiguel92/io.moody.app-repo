package io.moody.app;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class MoodletDAO implements IDAOMulti<Moodlet> {

    public boolean createRecord(List<Moodlet> data) {
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

    public List<Moodlet> readRecord(long id) {
        return new ArrayList<>();
    }

    public boolean updateRecord(List<Moodlet> data) {
        return false;
    }

    public boolean deleteRecord(long id) {
        return false;
    }
}
