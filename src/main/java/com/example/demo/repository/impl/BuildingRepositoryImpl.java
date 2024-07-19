package com.example.demo.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.bean.BuildingFullEnities;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.enity.BuildingEnity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "nhatdo";
    static final String PASS = "nhat2353";

    @Override
    public List<BuildingEnity> findAll(String name, Long districtid) {
        // stringbuilder ko phai String
        StringBuilder sql = new StringBuilder();
        // 1=1 nghia la dk luon dung
        sql.append("SELECT * FROM building b WHERE 1 = 1 ");
        if (name != null && !name.equals("")) {
            sql.append("AND b.name LIKE '%" + name + "%'");
        }
        if (districtid != null) {
            sql.append("AND b.districtid = '" + districtid + "'");
        }
        List<BuildingEnity> result = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql.toString());) {
            while (rs.next()) {
                BuildingEnity building = new BuildingEnity();
                // co the hieu rang la no dang lay du lieu tu cac column vay nen can phai set
                // nam
                // building duoc khoi tao dang bi rooxng nen can set name chu khong phai get
                // khong la se bi tra ra true;
                building.setName(rs.getString("name"));
                building.setStreet(rs.getString("street"));
                building.setWard(rs.getString("ward"));
                building.setNumberofbasement2(rs.getString("numberofbasement"));
                result.add(building);
                // result nơi nhận dữ liệu
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("loi la" + e.getMessage());
        }
        return result;
    }

    // dung khi implement vs interface khac
    @Override
    public List<BuildingFullEnities> search(Map<String, String> map) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM building b WHERE 1=1 ");
        List<BuildingFullEnities> result = new ArrayList<>();
        // viet query
        for (Map.Entry<String, String> x : map.entrySet()) {
            String key = x.getKey();
            String value = x.getValue();
            if (key != null && key.equals("name")) {
                sql.append("AND b.name LIKE '%" + value + "%' ");
            }
            if (key != null && key.equals("floorarea")) {
                sql.append("AND b.floorarea = " + value + " ");
            }
            if (key != null && key.equals("districtid")) {
                sql.append("AND JOIN district d ON b.districtid = d.id WHERE b.districtid = " + value + " ");
            }
            if (key != null && key.equals("ward")) {
                sql.append("AND b.ward LIKE '%" + value + "%' ");
            }
            if (key != null && key.equals("street")) {
                sql.append("AND b.street LIKE '%" + value + "%' ");
            }
            if (key != null && key.equals("numberofbasement")) {
                sql.append("AND b.numberofbasement = " + value + " ");
            }
            if (key != null && key.equals("direction")) {
                sql.append("AND b.direction LIKE '%" + value + "%' ");
            }
            if (key != null && key.equals("level")) {
                sql.append("AND b.level LIKE '%" + value + "%' ");
            }
            if (key != null && key.equals("areafrom")) {
                sql.append("AND b.floorarea >= " + value);
            }
            if (key != null && key.equals("areato")) {
                sql.append("AND b.floorarea <= " + value);
            }
            if (key != null && key.equals("rentfrom")) {
                sql.append("AND b.rentprice <= " + value);
            }
            if (key != null && key.equals("rentto")) {
                sql.append("AND b.rentprice >= " + value);
            }
            if (key != null && key.equals("managername")) {
                sql.append("AND b.managername LIKE '%" + value + "%' ");
            }
            if (key != null && key.equals("managerphonenumber")) {
                sql.append("AND b.managerphonenumber = " + value + " ");
            }
            if (key != null && key.equals("typecode")) {
                sql.append("JOIN renttype r ON b.id = r.id AND r.code like '%" + value + "%' ");
            }
            if (key != null && key.equals("staffid")) {
                sql.append("AND staffid = " + value);
            }
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql.toString());) {
            while (rs.next()) {
                // ... lam sau
                BuildingFullEnities building = new BuildingFullEnities();
                building.setDate(rs.getString("createddate"));
                building.setName(rs.getString("name"));
                building.setAdress(rs.getString("ward") + "," + rs.getString("street") + "," + rs.getString("name"));
                building.setNumberofbasements(rs.getString("numberofbasements"));
                building.setManagername(rs.getString("managername"));
                building.setManagerphonenumber(rs.getString("managerphonenumber"));
                building.setFloorarea(rs.getString("floorarea"));
                building.setEmptyarea(rs.getString("emptyarea"));
                building.setRentprice(rs.getString("rentprice"));
                building.setServicefee(rs.getString("servicefee"));
                building.setBrokeragefee(rs.getString("brokeragefee"));
                // building.setRentarea();
                result.add(building);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Da bi loi boi " + e.getMessage());
        }
        return result;
    }

}
