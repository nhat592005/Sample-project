package com.example.demo.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.enity.BuildingEnity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository  {

       static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
       static final String USER = "nhatdo";
       static final String PASS = "nhat2353";
    @Override
    public List<BuildingEnity> findAll( String name , Long districtid ) {
        //stringbuilder ko phai String
         StringBuilder sql = new StringBuilder();
         //1=1 nghia la dk luon dung 
         sql.append("SELECT * FROM building b WHERE 1 = 1 ");
         if ( name != null && !name.equals("")){
            sql.append("AND b.name LIKE '%" + name + "%'");
         }
         if(districtid != null){
            sql.append("AND b.districtid = '" + districtid + "'" );
         }
        List<BuildingEnity> result = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString()); ){
            while(rs.next()){
            BuildingEnity building = new BuildingEnity();
            //co the hieu rang la no dang lay du lieu tu cac column vay nen can phai set nam
            //building duoc khoi tao dang bi rooxng nen can set name chu khong phai get
            //khong la se bi tra ra true;
            building.setName(rs.getString("name"));
            building.setStreet(rs.getString("street"));
            building.setWard(rs.getString("ward"));
            building.setNumberofbasement2(rs.getString("numberofbasement"));
            result.add(building);
            //result nơi nhận dữ liệu
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println( "loi la" + e.getMessage());
        }
        return result;
    }
        
}
