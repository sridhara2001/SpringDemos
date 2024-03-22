package com.bookapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookDb {
    static Connection connection;

    public static Connection openConnection(){
        String url = "jdbc:mysql://localhost:3306/voyatraining";
        String userName = "root";
        String userPassword = "root";
        try {
            connection = DriverManager.getConnection(url,userName,userPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
