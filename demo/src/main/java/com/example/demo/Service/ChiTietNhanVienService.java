package com.example.demo.Service;

import com.example.demo.Entity.ChiTietNhanVienEntity;
import com.example.demo.Repository.ChiTietNhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietNhanVienService {
    @Autowired
    private ChiTietNhanVienRepository chiTietNhanVienRepository;

    public List<ChiTietNhanVienEntity> FindAll() {
        return chiTietNhanVienRepository.findAll();
    }

    public Optional<ChiTietNhanVienEntity> FindById(Long id) {
        return chiTietNhanVienRepository.findById(id);
    }

    public ChiTietNhanVienEntity Insert(ChiTietNhanVienEntity chiTietNhanVien) {
        return chiTietNhanVienRepository.save(chiTietNhanVien);
    }

    public ChiTietNhanVienEntity Update(ChiTietNhanVienEntity chiTietNhanVien) {
        return chiTietNhanVienRepository.save(chiTietNhanVien);
    }

    public void Delete(Long id) {
        chiTietNhanVienRepository.deleteById(id);
    }

    public List<ChiTietNhanVienEntity> GetAllActive() {
        return chiTietNhanVienRepository.GetAllActive();
    }

    public Optional<ChiTietNhanVienEntity> GetByFK(Long id) {
        return chiTietNhanVienRepository.GetByFK(id);
    }
}
