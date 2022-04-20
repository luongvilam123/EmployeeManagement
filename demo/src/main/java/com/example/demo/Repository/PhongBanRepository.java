package com.example.demo.Repository;

import com.example.demo.Entity.PhongBanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhongBanRepository extends JpaRepository<PhongBanEntity, Long> {
    @Query(value = "SELECT u FROM PhongBanEntity u WHERE u.status = 1")
    List<PhongBanEntity> GetAllActive();
}
