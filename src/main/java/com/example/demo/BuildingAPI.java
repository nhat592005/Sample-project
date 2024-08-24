package com.example.demo;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.bean.BuildingFullEnities;
import com.example.demo.service.impl.BuildingServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;

//tao ra cai controller de quan ly 4 yeu cau cua web
// import org.springframework.web.bind.annotation.PutMapping;
@RestController
public class BuildingAPI {
    @Autowired
    private BuildingServiceImpl buildingService;

    @GetMapping("/api/building/search/")
    public List<BuildingFullEnities> getBuilding(@RequestParam(required = false) Map<String, Object> params,
            @RequestParam(value = "typeCode", required = false) List<String> typeCode) {
        // khi đó tầng view sẽ phải xuống service để tìm dữ liệu
        List<BuildingFullEnities> result = buildingService.findAll(params, typeCode);
        return result;
    }

    @DeleteMapping("/api/introduce/{id}/{name}")
    public String xoa(@PathVariable Integer id, @PathVariable String name, @RequestParam(value = "born") Integer born) {
        System.out.println("da xoa " + name + id + born);
        return "da xoa " + name + " " + id + " " + born;
    }

    @GetMapping("/api/test")
    public String test(@RequestParam Map<String, String> map) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM building b WHERE 1=1 ");
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (key.equals("name") && !key.isEmpty()) {
                sql.append("AND b.name = '%" + value + "%' ");
            }
            if (key.equals("namsinh")) {
                sql.append("AND b.namsinh = " + value + " ");
            }
            if (key.equals("ward")) {
                sql.append("AND b.ward =" + value + " ");
            }
        }
        return sql.toString();
    }

}
