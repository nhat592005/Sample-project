package com.example.demo.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.RentAreaRepository;
import com.example.demo.repository.enity.RentAreaEnity;
import com.example.demo.repository.ultis.ConnectionSQL;

@Repository
public class RentAreaRepositoryImple implements RentAreaRepository {
    @Override
    public List<RentAreaEnity> getValueById(Long id) {
        String sql = "SELECT * FROM rentarea r  WHERE r.buildingid =  " + id;
        List<RentAreaEnity> rentArea = new ArrayList<>();
        try (Connection conn = ConnectionSQL.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                RentAreaEnity rentAreaEnity = new RentAreaEnity();
                rentAreaEnity.setValue(rs.getString("value"));
                rentArea.add(rentAreaEnity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("loi do " + e.getMessage());
        }
        return rentArea;
    }

}
