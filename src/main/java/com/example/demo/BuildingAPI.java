package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.bean.BuildingDTO;
import com.example.demo.repository.enity.BuildingFullEnities;
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
    private BuildingRepositoryImpl buildingrepository;

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

    @PostMapping("/api/building/search")
    public List<BuildingFullEnities> search(@RequestParam(value = "name", required = false) String name) {
        List<BuildingFullEnities> result = buildingrepository.search(name);
        return result;
    }

}
