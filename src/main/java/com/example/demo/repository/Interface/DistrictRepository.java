package com.example.demo.Repository.Interface;
import org.springframework.stereotype.Repository;

import com.example.demo.Repository.entity.DistrictEntity;

//chinh sua sang jpa
@Repository
//jpa bắt buộc phải ném entity cần và biến id
public interface DistrictRepository {
    DistrictEntity findNameById(DistrictEntity value );
}
