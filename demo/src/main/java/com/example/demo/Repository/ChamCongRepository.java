package com.example.demo.Repository;

import com.example.demo.Entity.ChamCongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface ChamCongRepository extends JpaRepository<ChamCongEntity, Long> {
    @Query(value = "SELECT u FROM ChamCongEntity u WHERE u.status = 1")
    List<ChamCongEntity> GetAllActive();

    @Query(value = "SELECT cc FROM ChamCongEntity cc " +
            "WHERE cc.nhanVien.nhanVienId = ?1 AND cc.status = 1" +
            "AND FUNCTION('MONTH',cc.ngayChamCong) = ?2 AND FUNCTION('YEAR',cc.ngayChamCong) = ?3")
    List<ChamCongEntity> GetChamCongByNhanVien(Long id, int month, int year);

    @Query(value = "SELECT cc FROM ChamCongEntity cc WHERE cc.ngayChamCong = ?1")
    List<ChamCongEntity> GetChamCongByTime(LocalDate time);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ChamCongEntity cc SET cc.status = 0 WHERE cc.nhanVien.nhanVienId = ?1")
    void RemoveChamCongByNhanVien(Long nhanVienId);
    
    @Query(value = "SELECT cc FROM ChamCongEntity cc WHERE cc.status = 1 AND FUNCTION('YEAR', cc.ngayChamCong) = ?1")
    List<ChamCongEntity> GetChamCongByYear(int year);
}
