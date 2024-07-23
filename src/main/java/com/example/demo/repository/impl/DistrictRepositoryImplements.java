package com.example.demo.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.enity.DistrictEnity;

@Repository
public class DistrictRepositoryImplements implements DistrictRepository {
    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "nhatdo";
    static final String PASS = "nhat2353";

    @Override
    public DistrictEnity findNameById(Long value) {
        String sql = "SELECT d.name FROM district d WHERE d.id = " + value + ";";
        DistrictEnity district = new DistrictEnity();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                district.setName(rs.getString("name"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return district;
    }

}
