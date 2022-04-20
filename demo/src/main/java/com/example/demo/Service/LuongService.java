package com.example.demo.Service;

import com.example.demo.Entity.LuongEntity;
import com.example.demo.Repository.LuongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LuongService {
    @Autowired
    private LuongRepository luongRepository;

    public List<LuongEntity> FindAll() {
        return luongRepository.findAll();
    }

    public Optional<LuongEntity> FindById(Long id) {
        return luongRepository.findById(id);
    }

    public LuongEntity Insert(LuongEntity luong) {
        return luongRepository.save(luong);
    }

    public LuongEntity Update(LuongEntity luong) {
        return luongRepository.save(luong);
    }

    public void Delete(Long id) {
        luongRepository.deleteById(id);
    }

    public List<LuongEntity> GetAllActive() {
        return luongRepository.GetAllActive();
    }

    public List<LuongEntity> GetLuongByTime(int month, int year) {
        return luongRepository.GetLuongByTime(month, year);
    }

    public void RemoveLuongByNhanVien(Long nhanVienId) {
        luongRepository.RemoveLuongByNhanVien(nhanVienId);
    }
}
