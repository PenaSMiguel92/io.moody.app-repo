package io.moody.app;

public class User {
    int id;
    String username;
    String email;
    String pass;
    Moodlet[] moodlets;

    User(String username, String email, String pass) {
        this.username = username;
        this.email = email;
        this.pass = pass;
    }
}
