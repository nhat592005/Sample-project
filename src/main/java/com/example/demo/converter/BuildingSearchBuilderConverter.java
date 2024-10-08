package com.example.demo.Converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.Builder.BuildingSearchBuilder;
import com.example.demo.Ultis.MapUltil;

//Xây dựng đối tượng: Phương thức build() sẽ trả về một đối tượng BuildingSearchBuilder với các thuộc tính đã được thiết lập.
//setName(MapUltil.getObject(params, "name", String.class)): Lấy giá trị của tham số "name" từ params và thiết lập nó cho thuộc tính name của đối tượng BuildingSearchBuilder.
@Component
public class BuildingSearchBuilderConverter {
    // đây là thay vì dùng map bị hạn chế 1 số thứ
    // sau khi call api tu frontend thi den day de xu ly du lieu thanh 1 khoi bean
    // sau đó mới xuống phần repository để lấy dữ liệu từ sql
    public BuildingSearchBuilder tobBuildingSearchBuilder(Map<String, Object> params, List<String> typeCode) {
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                .setName(MapUltil.getObject(params, "name", String.class))
                .setFloorarea(MapUltil.getObject(params, "floorarea", Long.class))
                .setWard(MapUltil.getObject(params, "ward", String.class))
                .setStreet(MapUltil.getObject(params, "street", String.class))
                .setNumberofbasement(MapUltil.getObject(params, "numberofbasement", Integer.class))
                .setDistrictid(MapUltil.getObject(params, "districtid", Long.class))
                .setManagername(MapUltil.getObject(params, "managername", String.class))
                .setServicefee(MapUltil.getObject(params, "servicefee", String.class))
                .setManagerphonenumber(MapUltil.getObject(params, "managerphonenumber", String.class))
                .setRentpricefrom(MapUltil.getObject(params, "rentpricefrom", Long.class))
                .setRentpriceto(MapUltil.getObject(params, "rentpriceto", Long.class))
                .setAreafrom(MapUltil.getObject(params, "areafrom", Long.class))
                .setAreato(MapUltil.getObject(params, "areato", Long.class))
                .setStaffid(MapUltil.getObject(params, "staffid", Long.class))
                .setLevel(MapUltil.getObject(params, "level", Long.class))
                // typecode ko phải chuyển đổi do nó có String sẵn nên k càafn
                .setTypeCode(typeCode)
                .build();

        return buildingSearchBuilder;
    }
}
