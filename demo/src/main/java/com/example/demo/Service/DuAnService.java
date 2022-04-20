package com.example.demo.Service;

import com.example.demo.Entity.DuAnEntity;
import com.example.demo.Repository.DuAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuAnService {
    @Autowired
    private DuAnRepository duAnRepository;

    public List<DuAnEntity> FindAll() {
        return duAnRepository.findAll();
    }

    public Optional<DuAnEntity> FindById(Long id) {
        return duAnRepository.findById(id);
    }

    public DuAnEntity Insert(DuAnEntity phongBan) {
        return duAnRepository.save(phongBan);
    }

    public DuAnEntity Update(DuAnEntity phongBan) {
        return duAnRepository.save(phongBan);
    }

    public void Delete(Long id) {
        duAnRepository.deleteById(id);
    }

    public List<DuAnEntity> GetAllActive() {return duAnRepository.GetAllActive();}
}
