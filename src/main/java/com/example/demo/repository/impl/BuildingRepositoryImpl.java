package com.example.demo.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.enity.BuildingEnity;
import com.example.demo.repository.ultis.ConnectionSQL;
import com.example.demo.repository.ultis.checkStringorNumber;

//nen nho ko dc thieu khong ala k chay dc
@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

    public static void jointable(Map<String, Object> params, List<String> typeCode, StringBuilder sql) {
        // nen lam moi thu ro rang theo string hoac j do cx dc
        // get value tu key
        String staffId = (String) params.get("staffid");
        if (staffId != null && !staffId.equals("")) {
            sql.append(" INNER JOIN assignmentbuilding c ON b.id = c.buildingid ");
        }
        // typecode duoc requerst rieng nen co the lay duoc nhieu cai
        if (typeCode != null && typeCode.size() != 0) {
            sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
        }
        // dasy la value
        String rentAreaTo = (String) params.get("areaTo");
        String rentAreaFrom = (String) params.get("areaFrom");
        if (rentAreaTo != null && !rentAreaTo.equals("") || rentAreaFrom != null && !rentAreaFrom.equals("")) {
            sql.append(" INNER JOIN rentarea ON b.id = rentarea.buildingid ");
        }
    }

    public static void normalQuery(Map<String, Object> params, List<String> typeCode, StringBuilder sql) {
        // su xy nhung qury don gian nhu like hay = ;
        // can tao mot bean de xem la number hay j
        for (Map.Entry<String, Object> it : params.entrySet()) {
            // bat buoc phai loai bo nhung th dac biet
            if (!it.getKey().equals("staffid") && !it.getKey().equals("typeCode") && !it.getKey().equals("areaTo")
                    && !it.getKey().equals("areaFrom") && !it.getKey().startsWith("rentp")) {
                // bat dau viet lenh cho normal query
                String value = (String) it.getValue();
                String key = (String) it.getKey();
                if (checkStringorNumber.checkNumber(value)) {
                    sql.append(" AND b." + key + " = " + value);
                } else if (!checkStringorNumber.checkNumber(value)) {
                    sql.append(" AND b." + key + " LIKE '%" + value + "%' ");
                }
            }
        }
    }

    public static void specialQuery(Map<String, Object> params, List<String> typeCode, StringBuilder sql) {
        for (Map.Entry<String, Object> it : params.entrySet()) {
            String staffid = (String) params.get("staffid");
            if (staffid != null && !staffid.equals("") && !checkStringorNumber.checkNumber(staffid)) {
                sql.append(" AND c.staffid = " + it.getValue());
            }
            // doan typecode nay phai xu ly can than
            if (typeCode != null && typeCode.size() != 0) {
                List<String> code = new ArrayList<>();
                for (String item : typeCode) {
                    code.add("'" + item + "'");
                }
                sql.append("AND renttype.code IN (" + String.join(",", code) + ") ");
            }
            String areaTo = (String) params.get("areaTo");
            String areaFrom = (String) params.get("areaFrom");
            if (checkStringorNumber.checkNumber(areaTo) || checkStringorNumber.checkNumber(areaFrom)) {
                if (areaTo != null && !areaTo.equals("")) {
                    sql.append(" AND rentarea.value <= " + it.getValue());
                }
                if (areaFrom != null && !areaFrom.equals("")) {
                    sql.append(" AND rentarea.value >= " + it.getValue());
                }
            }
            String rentAreaTo = (String) params.get("rentareato");
            String rentAreaFrom = (String) params.get("rentareafrom");
            if (checkStringorNumber.checkNumber(rentAreaFrom) || checkStringorNumber.checkNumber(rentAreaTo)) {
                if (rentAreaTo != null) {
                    sql.append(" AND b.rentprice <= " + it.getValue());
                }
                if (rentAreaFrom != null) {
                    sql.append(" AND b.rentprice >= " + it.getValue());
                }
            }
        }
    }

    // dung khi implement vs interface khac
    @Override
    public List<BuildingEnity> findAll(Map<String, Object> params, List<String> typeCode) {
        // nen tao query theo quy tac SELECT -> Join(neu co) -> normalQuery ->
        // specialQuery
        // nen tao 3 cai ham de lam theo de de debug
        StringBuilder sql = new StringBuilder();
        sql.append(
                "SELECT b.id ,b.name , b.ward , b.street , b.districtid , b.numberofbasement , b.managername, b.managerphonenumber,b.floorarea,b.rentprice,b.servicefee,b.brokeragefee FROM building b ");
        // tao lenh join
        jointable(params, typeCode, sql);
        sql.append("WHERE 1 = 1 ");
        normalQuery(params, typeCode, sql);
        specialQuery(params, typeCode, sql);
        sql.append(" GROUP BY b.id");
        System.out.println(sql.toString());
        List<BuildingEnity> result = new ArrayList<>();
        try (Connection conn = ConnectionSQL.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql.toString());) {
            while (rs.next()) {
                // ... lam sau
                BuildingEnity building = new BuildingEnity();
                building.setId(rs.getLong("id"));
                building.setName(rs.getString("name"));
                building.setWard(rs.getString("ward"));
                building.setStreet(rs.getString("street"));
                building.setDistrictid(rs.getLong("districtid"));
                building.setNumberofbasement(rs.getLong("numberofbasement"));
                building.setManagername(rs.getString("managername"));
                building.setManagerphonenumber(rs.getString("managerphonenumber"));
                building.setFloorarea(rs.getLong("floorarea"));
                building.setRentprice(rs.getLong("rentprice"));
                building.setServicefee(rs.getString("servicefee"));
                // brokegarefee la phi moi gioi;
                building.setBrokeragefee(rs.getLong("brokeragefee"));
                // building.setRentarea();
                result.add(building);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
}
