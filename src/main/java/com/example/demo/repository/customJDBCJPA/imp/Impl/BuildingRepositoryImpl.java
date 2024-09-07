package com.example.demo.Repository.customJDBCJPA.imp.Impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.example.demo.Builder.BuildingSearchBuilder;
import com.example.demo.Repository.customJDBCJPA.imp.BuildingRepositoryCustom;
import com.example.demo.Repository.entity.BuildingEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

//nen nho ko dc thieu khong ala k chay dc
@Repository
@Primary
public class BuildingRepositoryImpl implements BuildingRepositoryCustom  {
    // sau khi convert tất cả dữ liệu rồi thì sẽ có chỉ cần dùng cái
    // buildingsearchbuilder
    @PersistenceContext
    EntityManager entityManager;

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
        try {
            /// bat dau lay du lieu cho design building patter;
            // tạo 1 cái mảng field để lưu các field
            Field fields[] = BuildingSearchBuilder.class.getDeclaredFields();
            for (Field item : fields) {
                // accesible la cho phep de duyet cac field;
                // bat buoc la phai dung true
                item.setAccessible(true);
                // lấy tên key field
                String fieldName = item.getName();
                // fieldname co the dc coi la key
                // con value la cai gia tri cua cai itemfield tra ra khi quet
                // cái fieldname đặc biệt đã dc xử lỹ ở trên nên k cần nữa
                if (!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.equals("areaTo")
                        && !fieldName.equals("areaFrom") && !fieldName.startsWith("rentp")) {
                    // item tức là field nên đây là lấy value của cái field đấy
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
    @SuppressWarnings("unchecked")
    public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
        // nen tao query theo quy tac SELECT -> Join(neu co) -> normalQuery ->
        // specialQuery
        // nen tao 3 cai ham de lam theo de de debug
        StringBuilder sql = new StringBuilder();
        // * ở đây là là laayst tất cả những gì entity có chứ k phải của bảng table sql 
        sql.append("SELECT b.* FROM building b ");
        // tao lenh join
        jointable(buildingSearchBuilder, sql);
        sql.append("WHERE 1 = 1 ");
        normalQuery(buildingSearchBuilder, sql);
        specialQuery(buildingSearchBuilder, sql);
        sql.append(" GROUP BY b.id");
        System.out.println(sql.toString());
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }
}
