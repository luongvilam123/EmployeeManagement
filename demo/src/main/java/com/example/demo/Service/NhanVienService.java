package com.example.demo.Service;

import com.example.demo.Entity.NhanVienEntity;
import com.example.demo.Repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVienEntity> FindAll() {
        return nhanVienRepository.findAll();
    }

    public Optional<NhanVienEntity> FindById(Long id) {
        return nhanVienRepository.findById(id);
    }

    public NhanVienEntity Insert(NhanVienEntity nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public NhanVienEntity Update(NhanVienEntity nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public void Delete(Long id) {
        nhanVienRepository.deleteById(id);
    }

    public List<NhanVienEntity> GetAllActive() {
        return nhanVienRepository.GetAllActive();
    }

    public List<NhanVienEntity> GetNhanVienByPhongBan(Long id) {
        return nhanVienRepository.GetNhanVienByPhongBan(id);
    }

    public List<NhanVienEntity> GetNhanVienByChucVu(Long id) {
        return nhanVienRepository.GetNhanVienByChucVu(id);
    }

    public List<NhanVienEntity> GetNhanVienByCongViec(Long id) {
        return nhanVienRepository.GetNhanVienByCongViec(id);
    }
}
