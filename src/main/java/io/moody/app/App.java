package io.moody.app;

//import java.util.*;
import java.io.IOException;
import java.sql.*;
import io.javalin.Javalin;

public class App 
{
    public static void main( String[] args )
    {
        Javalin app = Javalin.create();
        app.get("/", ctx -> ctx.result("Hello World!"));
        app.get("/sample-area", ctx -> ctx.result("Let's see if we can return this!"));
        app.start(8080);
        
        // try (Connection connection = DatabaseUtil.getConnection();) {
        //     System.out.print("success");
        //     // UserDAO userDAO = new UserDAO(connection);
        //     // User newUser = new User("blehman3000", "suckthis@notanemail.com", "lickme123");
        //     // userDAO.createRecord(newUser);
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
}
