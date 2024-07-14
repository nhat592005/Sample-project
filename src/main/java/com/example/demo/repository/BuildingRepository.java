package com.example.demo.repository;

import java.util.List;


import com.example.demo.repository.enity.BuildingEnity;

public interface BuildingRepository {
    List<BuildingEnity> findAll(String name , Long districtid); 
}
