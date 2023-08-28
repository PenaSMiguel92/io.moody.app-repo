package io.moody.app;

import java.util.*;

public class Family {
    private long id;
    private User primaryUser;
    private List<User> otherUsers;

    Family() {
        this.otherUsers = new ArrayList<>();
    }
    
    Family(User primaryUser) {
        this.primaryUser = primaryUser;
        this.otherUsers = new ArrayList<>();
    }

    @Override
    public boolean equals(Object other) {
        if (this != other)
            return false;
        if (this.getClass() != other.getClass())
            return false;

        Family otherObj = (Family) other;

        if (this.id == otherObj.id)
            return true;

        return (this.primaryUser == otherObj.getPrimaryUser() && this.otherUsers == otherObj.otherUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.primaryUser, this.otherUsers);
    }

    @Override
    public String toString() {
        String val = "Family [" + "primaryUser: " + this.primaryUser.getUsername() + ", ";
        User[] users = this.otherUsers.stream().toArray(User[]::new);
        int count = 0;
        for (User user : users) {
            val += "otherUser" + ++count + ": " + user.getUsername();
            String tail = count < users.length + 1 ? ", " : " ";
            val += tail;
        }
        val += "]";
        return val;
    }

    public User getPrimaryUser() {
        return this.primaryUser;
    }

    public void setPrimaryUser(User user) {
        this.primaryUser = user;
    }

    public List<User> getOtherUsers() {
        return this.otherUsers;
    }
}
