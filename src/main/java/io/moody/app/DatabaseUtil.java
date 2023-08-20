package io.moody.app;

import java.io.*;
import java.util.*;
import java.sql.*;

public class DatabaseUtil {
    private static String URL;
    private static String CONNECTION_USERNAME;
    private static String CONNECTION_PASSWORD;
    
    public static Connection getConnection() throws SQLException, FileNotFoundException, IOException {
        FileInputStream fileStream = new FileInputStream("./moodyDB.properties");
        Properties properties = new Properties();
        properties.load(fileStream);
        URL = properties.getProperty("URL");
        CONNECTION_USERNAME = properties.getProperty("CONNECTION_USERNAME");
        CONNECTION_PASSWORD = properties.getProperty("CONNECTION_PASSWORD");

        return DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
    }
}
