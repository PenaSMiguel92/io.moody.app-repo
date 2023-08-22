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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public User readRecord(int id) {
        String username = "";
        String email = "";
        String pass = "";
        return new User(username, email, pass);
    }

    public boolean updateRecord(User data) {
        return true;
    }

    public boolean deleteRecord(int id) {
        return true;
    }
}
