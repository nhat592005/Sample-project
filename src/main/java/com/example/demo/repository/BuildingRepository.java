package com.example.demo.repository;

import java.util.List;


import com.example.demo.repository.enity.BuildingEnity;
import com.example.demo.repository.enity.BuildingFullEnities;

public interface BuildingRepository {
    List<BuildingEnity> findAll(String name , Long districtid);   
    List< BuildingFullEnities> search (BuildingFullEnities building);
}
