package io.moody.app;

import java.sql.*;

public class UserDAO implements IDataAccessObject<User> {
    Connection connection;
    UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean createRecord(User data) {
        try {
            String sql = "INSERT INTO site_user (username, email, pass) VALUES (?, ?, ?)"; 
            PreparedStatement stmnt = this.connection.prepareStatement(sql);
            stmnt.setString(1, data.username);
            stmnt.setString(2, data.email);
            stmnt.setString(3, data.pass);
            stmnt.executeUpdate();

            String sql2 = "SELECT id FROM site_user WHERE username = " + data.username;
            Statement stmnt2 = this.connection.createStatement();
            ResultSet rs = stmnt2.executeQuery(sql2);
            int id = 0;
            while (rs.next()) {
                id = rs.getInt("id");
            }
            data.setId(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public User readRecord(int id) {
        String username = "";
        String email = "";
        String pass = "";
        try {
            String sql = "SELECT username, email, pass FROM site_user WHERE id = " + id;
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
            String sql = "UPDATE site_user SET username = ?, email = ?, pass = ? WHERE id = ?";
            PreparedStatement stmnt = this.connection.prepareStatement(sql);
            stmnt.setString(1, data.username);
            stmnt.setString(2, data.email);
            stmnt.setString(3, data.pass);
            stmnt.setInt(4, data.getId());
            int rowsAffected = stmnt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean deleteRecord(int id) {
        boolean success = false;
        try {
            String sql = "DELETE FROM site_user WHERE id = ?";
            PreparedStatement stmnt = this.connection.prepareStatement(sql);
            stmnt.setInt(1, id);
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
