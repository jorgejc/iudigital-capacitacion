package com.iudigital.carcenter.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static final String URL = "jdbc:postgresql://localhost:5432/car-center";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";
    
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
