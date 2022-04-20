package com.example.demo.Repository;

import com.example.demo.Entity.TrangThaiChamCongEntity;
import com.example.demo.Entity.TrangThaiChamCongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrangThaiChamCongRepository extends JpaRepository<TrangThaiChamCongEntity, Long> {
    @Query(value = "SELECT u FROM TrangThaiChamCongEntity u WHERE u.status = 1")
    List<TrangThaiChamCongEntity> GetAllActive();
}
