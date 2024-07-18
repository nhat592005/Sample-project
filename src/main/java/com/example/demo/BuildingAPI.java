package com.example.demo;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.bean.BuildingDTO;
import com.example.demo.bean.BuildingFullEnities;
import com.example.demo.service.impl.BuildingServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
//tao ra cai controller de quan ly 4 yeu cau cua web
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BuildingAPI {
    @Autowired
    private BuildingServiceImpl buildingServiceImpl;

    @GetMapping("/api/building/search/")
    // tra ve 11 cai field ma minh can
    public List<BuildingFullEnities> search(@RequestParam(required = false) Map<String, String> map) {
        return null;
    }

    @GetMapping("/api/building/")
    public List<BuildingDTO> getBuilding(@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "districtid", required = false) Long districtid) {
        List<BuildingDTO> result2 = buildingServiceImpl.findAll(name, districtid);
        return result2;
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
