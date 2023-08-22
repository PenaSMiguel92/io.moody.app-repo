package io.moody.app;

public class UserDAO implements IDataAccessObject<User> {
    
    public boolean createRecord(User data) {
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
