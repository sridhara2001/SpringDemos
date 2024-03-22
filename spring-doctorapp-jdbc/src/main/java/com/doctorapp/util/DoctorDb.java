package com.doctorapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DoctorDb {
    static Connection connection;
    public static Connection openConnection(){
        String url = "jdbc:mysql://localhost:3306/voyatraining";
        String name = "root";
        String password = "root";
        try {
            connection = DriverManager.getConnection(url,name,password);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
