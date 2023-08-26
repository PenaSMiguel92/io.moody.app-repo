package io.moody.app;

//import java.util.*;
import java.io.IOException;
import java.sql.*;
import io.javalin.Javalin;

public class App 
{
    public static void main( String[] args )
    {
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello World"));
        try (Connection connection = DatabaseUtil.getConnection();) {
            UserDAO userDAO = new UserDAO(connection);
            User newUser = new User("blehman3000", "suckthis@notanemail.com", "lickme123");
            userDAO.createRecord(newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
