package io.moody.app;

import java.util.*;

public class UserService {
    UserDAO userDAO;

    UserService() {
        this.userDAO = new UserDAO();
    }

    UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() {
        return this.userDAO.getAllRecords();
    }

    public boolean updateUserById(User user) {
        return this.userDAO.updateRecord(user);
    }

    public void createRecord(User user) {
        this.userDAO.createRecord(user);
    }



}
