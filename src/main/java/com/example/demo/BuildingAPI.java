package com.example.demo;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.bean.BuildingFullEnities;
import com.example.demo.repository.impl.BuildingRepositoryImpl;
import com.example.demo.service.impl.BuildingServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
//tao ra cai controller de quan ly 4 yeu cau cua web
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BuildingAPI {
    @Autowired
    private BuildingServiceImpl buildingServiceImpl;
    @Autowired
    private BuildingRepositoryImpl buildingRepositoryImpl;

    @GetMapping("/api/building/search/")
    // tra ve 11 cai field ma minh can
    // list thi can
    public List<BuildingFullEnities> getBuilding(@RequestParam(required = false) Map<String, Object> params,
            @RequestParam(value = "typecode", required = false) List<String> typeCode) {
        List<BuildingFullEnities> result = buildingRepositoryImpl.findAll(params, typeCode);
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
