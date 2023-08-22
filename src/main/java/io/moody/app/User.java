package io.moody.app;

import java.util.Objects;

public class User {
    private static long _id = 1;
    private long id;
    private String username;
    private String email;
    private String pass;
    private Moodlet[] moodlets;

    User(String username, String email, String pass) {
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.id = _id++;
    }

    void setId(long id) {
        this.id = id;
    }

    long getId() {
        return this.id;
    }

    String getUsername() {
        return this.username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    String getEmail() {
        return this.email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getPass() {
        return this.pass;
    }

    void setPass(String pass) {
        this.pass = pass;
    }

    Moodlet[] getMoodlets() {
        return this.moodlets;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.username, this.email, this.pass);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (other.getClass() != this.getClass())
            return false;

        User otherObj = (User) other;

        return otherObj.getId() == this.id;
    }

    @Override
    public String toString() {
        String passVal = "";
        for (int index = 0; index < this.pass.length(); index++) {
            passVal += "*";
        }
        return "User: " + this.id + "\n Username: " + this.username + "\n Email: " + this.email + "\n Pass: " + passVal;
    }
}
