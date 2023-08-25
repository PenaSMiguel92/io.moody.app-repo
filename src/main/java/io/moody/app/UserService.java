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

}
