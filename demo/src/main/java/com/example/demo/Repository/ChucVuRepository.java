package com.example.demo.Repository;

import com.example.demo.Entity.ChucVuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChucVuRepository extends JpaRepository<ChucVuEntity, Long> {
    @Query(value = "SELECT u FROM ChucVuEntity u WHERE u.status = 1")
    List<ChucVuEntity> GetAllActive();
}
