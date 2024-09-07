package com.example.demo.Repository.customJDBCJPA.imp.Impl;

import org.springframework.stereotype.Repository;

import com.example.demo.Repository.Interface.DistrictRepository;
import com.example.demo.Repository.entity.DistrictEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

//không cần thiết khi sử dụng jpa
@Repository
public class JDBCDistrictRepositoryImplements implements DistrictRepository {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public DistrictEntity findNameById(DistrictEntity value) {
        String sql = "SELECT d.name FROM district d WHERE d.id = " + value + ";";
        Query query = entityManager.createNativeQuery(sql);
        return (DistrictEntity) query.getSingleResult();
    }

}
