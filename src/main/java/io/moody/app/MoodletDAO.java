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

    public List<Moodlet> readRecord(long user_id) {
        List<Moodlet> moodlets = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "SELECT sleep_value, comfort_value, fun_value, hunger_value, social_value, toilet_value, hygiene_value FROM moodlet WHERE user_id_fk = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, user_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                List<Integer> moodlet_values = Arrays.asList(rs.getInt("sleep_value"), rs.getInt("comfort_value"),
                        rs.getInt("fun_value"), rs.getInt("hunger_value"), rs.getInt("social_value"),
                        rs.getInt("toilet_vlaue"), rs.getInt("hygiene_value"));

                List<String> moodlet_list = Arrays.asList("sleep_value", "comfort_value", "fun_value", "hunger_value",
                        "social_value", "toilet_value", "hygeine_value");
                Moodlet[] moodletsArray = moodlet_list.stream()
                        .map(Moodlet::new)
                        .toArray(Moodlet[]::new);

                for (int i = 0; i < moodletsArray.length; i++) {
                    moodletsArray[i].setValue(moodlet_values.get(i));
                    moodlets.add(moodletsArray[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moodlets;
    }

    public boolean updateRecord(List<Moodlet> data) {
        boolean success = false;
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "UPDATE moodlet SET ";
            for (int i = 0; i < data.size(); i++) {
                Moodlet mood = data.get(i);
                sql += mood.getName() + " = " + mood.getValue();
                String tail = i < data.size() - 1 ? ", " : " ";
                sql += tail;
            }
            sql += "WHERE user_id_fk = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, data.get(0).getOwnerId());
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

    public boolean deleteRecord(long id) {
        boolean success = false;
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "DELETE FROM moodlet WHERE user_id_fk = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
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
}
