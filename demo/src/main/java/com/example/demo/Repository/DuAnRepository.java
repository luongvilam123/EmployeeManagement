package com.example.demo.Repository;

import com.example.demo.Entity.DuAnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DuAnRepository extends JpaRepository<DuAnEntity, Long> {
    @Query(value = "SELECT u FROM DuAnEntity u WHERE u.status = 1")
    List<DuAnEntity> GetAllActive();
}
