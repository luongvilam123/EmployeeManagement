package com.example.demo.Repository;

import com.example.demo.Entity.ChiTietNhanVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChiTietNhanVienRepository extends JpaRepository<ChiTietNhanVienEntity, Long> {
    @Query(value = "SELECT u FROM ChiTietNhanVienEntity u WHERE u.status = 1")
    List<ChiTietNhanVienEntity> GetAllActive();

    @Query(value = "SELECT n FROM ChiTietNhanVienEntity n WHERE n.nhanVien.nhanVienId = ?1")
    Optional<ChiTietNhanVienEntity> GetByFK(Long id);
}
