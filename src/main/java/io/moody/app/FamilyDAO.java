package io.moody.app;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class FamilyDAO {

    public boolean createRecord(List<User> family, User primaryUser) {
        boolean success = false;
        try (Connection connection = DatabaseUtil.getConnection();) {
            Map<Integer, Long> map = new HashMap<>();
            int current = 1;
            String sql = "INSERT INTO user_family VALUES ";
            
            for (User member : family) {

                sql += "(DEFAULT, ?, ?)";
                map.put(current++, primaryUser.getId());
                map.put(current++, member.getId());
                String tail = current >= family.size() * 2 ? ";" : ",";
                sql += tail;
            }
            PreparedStatement ps = connection.prepareStatement(sql);
            map.forEach((key, value) -> {
                try {
                    ps.setLong(key, value);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0)
                success = true;
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return success;
    }

    public List<User> readRecord(long primaryUserId) {
        return new ArrayList<>();
    }

    public boolean updateRecord(List<User> family, User primaryUser) {
        return false;
    }

    public boolean deleteRecord(long primaryUserId) {
        return false;
    }
}
