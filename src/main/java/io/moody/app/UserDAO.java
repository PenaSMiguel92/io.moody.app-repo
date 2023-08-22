package io.moody.app;

import java.sql.*;

public class UserDAO implements IDataAccessObject<User> {
    Connection connection;
    UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean createRecord(User data) {
        boolean success = false;
        try {
            String sql = "INSERT INTO site_user (user_id, username, email, pass) VALUES (?, ?, ?, ?)"; 
            PreparedStatement stmnt = this.connection.prepareStatement(sql);
            stmnt.setLong(1, data.getId());
            stmnt.setString(2, data.getUsername());
            stmnt.setString(3, data.getEmail());
            stmnt.setString(4, data.getPass());
            int rowsAffected = stmnt.executeUpdate();
            if (rowsAffected > 0)
                success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public User readRecord(long id) {
        String username = "";
        String email = "";
        String pass = "";
        try {
            String sql = "SELECT username, email, pass FROM site_user WHERE user_id = " + id;
            Statement stmnt = this.connection.createStatement();
            ResultSet rs = stmnt.executeQuery(sql);

            while (rs.next()) {
                username = rs.getString("username");
                email = rs.getString("email");
                pass = rs.getString("pass");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User(username, email, pass);
    }

    public boolean updateRecord(User data) {
        boolean success = false;
        try {
            String sql = "UPDATE site_user SET username = ?, email = ?, pass = ? WHERE user_id = ?";
            PreparedStatement stmnt = this.connection.prepareStatement(sql);
            stmnt.setString(1, data.getUsername());
            stmnt.setString(2, data.getEmail());
            stmnt.setString(3, data.getPass());
            stmnt.setLong(4, data.getId());
            int rowsAffected = stmnt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean deleteRecord(long id) {
        boolean success = false;
        try {
            String sql = "DELETE FROM site_user WHERE user_id = ?";
            PreparedStatement stmnt = this.connection.prepareStatement(sql);
            stmnt.setLong(1, id);
            int rowsAffected = stmnt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
