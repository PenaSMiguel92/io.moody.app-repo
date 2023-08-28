package io.moody.app;

public class UserService {
    UserDAO userDAO;

    UserService() {
        this.userDAO = new UserDAO();
    }

    UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean updateUserById(User user) {
        return this.userDAO.updateRecord(user);
    }

    public void createRecord(User user) {
        this.userDAO.createRecord(user);
    }
}
