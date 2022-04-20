package com.example.demo.Service;

import com.example.demo.Entity.CongViecEntity;
import com.example.demo.Repository.CongViecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CongViecService {
    @Autowired
    private CongViecRepository congViecRepository;

    public List<CongViecEntity> FindAll() {
        return congViecRepository.findAll();
    }

    public Optional<CongViecEntity> FindById(Long id) {
        return congViecRepository.findById(id);
    }

    public CongViecEntity Insert(CongViecEntity congViec) {
        return congViecRepository.save(congViec);
    }

    public CongViecEntity Update(CongViecEntity congViec) {
        return congViecRepository.save(congViec);
    }

    public void Delete(Long id) {
        congViecRepository.deleteById(id);
    }

    public List<CongViecEntity> GetAllActive() {
        return congViecRepository.GetAllActive();
    }
}
