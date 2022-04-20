package com.example.demo.Service;

import com.example.demo.Entity.ChamCongEntity;
import com.example.demo.Repository.ChamCongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ChamCongService {
    @Autowired
    private ChamCongRepository chamCongRepository;

    public List<ChamCongEntity> FindAll() {
        return chamCongRepository.findAll();
    }

    public Optional<ChamCongEntity> FindById(Long id) {
        return chamCongRepository.findById(id);
    }

    public ChamCongEntity Insert(ChamCongEntity chamCong) {
        return chamCongRepository.save(chamCong);
    }

    public ChamCongEntity Update(ChamCongEntity chamCong) {
        return chamCongRepository.save(chamCong);
    }

    public void Delete(Long id) {
        chamCongRepository.deleteById(id);
    }

    public List<ChamCongEntity> GetAllActive() {
        return chamCongRepository.GetAllActive();
    }

    public List<ChamCongEntity> GetChamCongByNhanVien(Long id, int month, int year) {
        return chamCongRepository.GetChamCongByNhanVien(id, month, year);
    }

    public List<ChamCongEntity> GetChamCongByTime(LocalDate date) {
        return chamCongRepository.GetChamCongByTime(date);
    }

    public void RemoveChamCongByNhanVien(Long nhanVienId) {
        chamCongRepository.RemoveChamCongByNhanVien(nhanVienId);
    }
    
    public List<ChamCongEntity> GetChamCongByYear (int year) {
        return chamCongRepository.GetChamCongByYear (year);
    }
}
