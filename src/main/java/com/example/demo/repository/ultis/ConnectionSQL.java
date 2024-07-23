package com.example.demo.repository.ultis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    public static Connection getConnection() {
        final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
        final String USER = "nhatdo";
        final String PASS = "nhat2353";
        Connection conn = null;
        try {
            // day la
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("loi la tu ket noi data base " + e.getMessage());
        }
        return conn;
    }
}
