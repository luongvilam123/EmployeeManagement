package com.example.demo.Service;

import com.example.demo.Entity.PhongBanEntity;
import com.example.demo.Repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<PhongBanEntity> FindAll() {
        return phongBanRepository.findAll();
    }

    public Optional<PhongBanEntity> FindById(Long id) {
        return phongBanRepository.findById(id);
    }

    public PhongBanEntity Insert(PhongBanEntity phongBan) {
        return phongBanRepository.save(phongBan);
    }

    public PhongBanEntity Update(PhongBanEntity phongBan) {
        return phongBanRepository.save(phongBan);
    }

    public void Delete(Long id) {
        phongBanRepository.deleteById(id);
    }

    public List<PhongBanEntity> GetAllActive() {
        return phongBanRepository.GetAllActive();
    }
}
