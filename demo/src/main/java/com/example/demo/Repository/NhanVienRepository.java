package com.example.demo.Repository;

import com.example.demo.Entity.NhanVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NhanVienRepository extends JpaRepository<NhanVienEntity, Long> {
    @Query(value = "SELECT u FROM NhanVienEntity u WHERE u.status = 1")
    List<NhanVienEntity> GetAllActive();

    @Query(value = "SELECT nv FROM NhanVienEntity nv WHERE nv.phongBan.phongBanId = ?1 AND nv.status = 1")
    List<NhanVienEntity> GetNhanVienByPhongBan(Long id);

    @Query(value = "SELECT nv FROM NhanVienEntity nv WHERE nv.chucVu.chucVuId = ?1 AND nv.status = 1")
    List<NhanVienEntity> GetNhanVienByChucVu(Long id);

    @Query(value = "SELECT nv FROM NhanVienEntity nv WHERE nv.congViec.congViecId = ?1 AND nv.status = 1")
    List<NhanVienEntity> GetNhanVienByCongViec(Long id);
}
