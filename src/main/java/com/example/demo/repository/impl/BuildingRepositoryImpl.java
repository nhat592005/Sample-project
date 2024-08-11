package com.example.demo.repository.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

import com.example.demo.builder.BuildingSearchBuilder;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.enity.BuildingEnity;
import com.example.demo.repository.ultis.ConnectionSQL;

//nen nho ko dc thieu khong ala k chay dc
@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

    public static void jointable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
        // nen lam moi thu ro rang theo string hoac j do cx dc
        // get value tu key
        Long staffId = buildingSearchBuilder.getStaffid();
        if (staffId != null) {
            sql.append(" INNER JOIN assignmentbuilding c ON b.id = c.buildingid ");
        }
        List<String> typeCode = buildingSearchBuilder.getTypeCode();
        // typecode duoc requerst rieng nen co the lay duoc nhieu cai
        if (typeCode != null && typeCode.size() != 0) {
            sql.append(" INNER JOIN buildingrenttype brt ON b.id = brt.buildingid ");
            sql.append(" INNER JOIN renttype rt ON 1=1 ");
        }
        // dasy la value
        Long rentAreaTo = buildingSearchBuilder.getAreato();
        Long rentAreaFrom = buildingSearchBuilder.getAreato();
        if (rentAreaTo != null || rentAreaFrom != null) {
            sql.append(" INNER JOIN rentarea ON b.id = rentarea.buildingid ");
        }
    }

    public static void normalQuery(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
        // su xy nhung qury don gian nhu like hay = ;
        // can tao mot bean de xem la number hay j
        // cach 1 la su dung map cach 2 de gon gang clean thi dung design building
        // pattern
        // for (Map.Entry<String, Object> it : params.entrySet()) {
        // // bat buoc phai loai bo nhung th dac biet
        // if (!it.getKey().equals("staffid") && !it.getKey().equals("typeCode") &&
        // !it.getKey().equals("areaTo")
        // && !it.getKey().equals("areaFrom") && !it.getKey().startsWith("rentp")) {
        // // bat dau viet lenh cho normal query
        // String value = (String) it.getValue();
        // String key = (String) it.getKey();
        // if (checkStringorNumber.checkNumber(value)) {
        // sql.append(" AND b." + key + " = " + value);
        // } else if (!checkStringorNumber.checkNumber(value)) {
        // sql.append(" AND b." + key + " LIKE '%" + value + "%' ");
        // }
        // }
        // }
        // }
        try {
            /// bat dau lay du lieu cho design building patter;
            Field fields[] = BuildingSearchBuilder.class.getDeclaredFields();
            for (Field item : fields) {
                // accesible la cho phep de duyet cac field;
                // bat buoc la phai dung true
                item.setAccessible(true);
                String fieldName = item.getName();
                // fieldname co the dc coi la key
                // con value la cai gia tri cua cai itemfield tra ra khi quet
                if (!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.equals("areaTo")
                        && !fieldName.equals("areaFrom") && !fieldName.startsWith("rentp")) {
                    Object value = item.get(buildingSearchBuilder);
                    if (value != null) {
                        if (item.getType().getName().equals("java.lang.Long")
                                || item.getType().getName().equals("java.lang.Integer")) {
                            sql.append(" AND b." + fieldName + " = " + value);
                        } else if (item.getType().getName().equals("java.lang.String")) {
                            sql.append(" AND b." + fieldName + " LIKE '%" + value + "%' ");
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi la " + e.getMessage());
        }
    }

    public static void specialQuery(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
        Long staffId = buildingSearchBuilder.getStaffid();
        if (staffId != null) {
            sql.append(" AND c.staffid = " + staffId);
        }
        // doan typecode nay phai xu ly can than
        // java 8
        List<String> typeCode = buildingSearchBuilder.getTypeCode();
        if (typeCode != null && typeCode.size() != 0) {
            sql.append(" AND(");
            String check = typeCode.stream().map(i -> " renttype.code like " + '%' + i + '%')
                    .collect(Collectors.joining(" OR "));
            sql.append(check);
            sql.append(" ) ");
        }
        // day co the duoc la gia tri lay duoc cua String;
        Long areaTo = buildingSearchBuilder.getAreato();
        Long areaFrom = buildingSearchBuilder.getAreato();
        if (areaTo != null) {
            sql.append(" AND rentarea.value <= " + areaTo);
        }
        if (areaFrom != null) {
            sql.append(" AND rentarea.value >= " + areaFrom);
        }
        Long rentAreaTo = buildingSearchBuilder.getAreato();
        Long rentAreaFrom = buildingSearchBuilder.getAreato();
        if (rentAreaTo != null) {
            sql.append(" AND b.rentprice <= " + rentAreaTo);
        }
        if (rentAreaFrom != null) {
            sql.append(" AND b.rentprice >= " + rentAreaFrom);
        }
    }

    // dung khi implement vs interface khac
    @Override
    public List<BuildingEnity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
        // nen tao query theo quy tac SELECT -> Join(neu co) -> normalQuery ->
        // specialQuery
        // nen tao 3 cai ham de lam theo de de debug
        StringBuilder sql = new StringBuilder();
        sql.append(
                "SELECT b.id ,b.name , b.ward , b.street , b.districtid , b.numberofbasement , b.managername, b.managerphonenumber,b.floorarea,b.rentprice,b.servicefee,b.brokeragefee FROM building b ");
        // tao lenh join
        jointable(buildingSearchBuilder, sql);
        sql.append("WHERE 1 = 1 ");
        normalQuery(buildingSearchBuilder, sql);
        specialQuery(buildingSearchBuilder, sql);
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
                building.setNumberofbasement(rs.getInt("numberofbasement"));
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
