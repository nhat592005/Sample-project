package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.builder.BuildingSearchBuilder;
import com.example.demo.repository.entity.BuildingEntity;

//day la cac  interfare để khiến dễ debug đọc hiểu hơn 
@Repository
public interface BuildingRepository {
    List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}
