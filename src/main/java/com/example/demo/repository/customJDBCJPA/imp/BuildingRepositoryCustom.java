package com.example.demo.Repository.customJDBCJPA.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Builder.BuildingSearchBuilder;
import com.example.demo.Repository.entity.BuildingEntity;

@Repository
public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}
