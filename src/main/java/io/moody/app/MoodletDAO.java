package io.moody.app;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class MoodletDAO implements IDAOMulti<Moodlet> {

    public boolean createRecord(List<Moodlet> data) {
        boolean success = false;
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO moodlet (user_id_fk, sleep_value, comfort_value, fun_value, hunger_value, social_vlaue, toilet_value, hygiene_value ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < data.size(); i++) {
                Moodlet currentMoodlet = data.get(i);
                if (i == 0) {
                    ps.setLong(1, currentMoodlet.getOwnerId());
                }
                ps.setInt(i + 2, currentMoodlet.getValue());
            }
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0)
                success = true;

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
