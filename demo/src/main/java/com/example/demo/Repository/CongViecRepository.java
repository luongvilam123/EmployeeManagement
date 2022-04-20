package com.example.demo.Repository;

import com.example.demo.Entity.CongViecEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CongViecRepository extends JpaRepository<CongViecEntity, Long> {
    @Query(value = "SELECT u FROM CongViecEntity u WHERE u.status = 1")
    List<CongViecEntity> GetAllActive();
}
