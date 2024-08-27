package com.example.demo.repository.custom.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.builder.BuildingSearchBuilder;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.entity.BuildingEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class BuildingRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    //@Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
        // JPQL format
        // thuc hien cau quey thay vi jdbc la enity manager
        // String sql = "FROM BuildingEntity b";
        // Query query = entityManager.createQuery(sql, BuildingEntity.class);

        // sql native
        String sql = "SELECT * FROM building b WHERE b.name like '%building%'";
        Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
        return query.getResultList();
    }
}
