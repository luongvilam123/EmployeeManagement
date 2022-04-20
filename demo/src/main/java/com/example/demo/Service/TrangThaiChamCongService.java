package com.example.demo.Service;

import com.example.demo.Entity.TrangThaiChamCongEntity;
import com.example.demo.Repository.TrangThaiChamCongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrangThaiChamCongService {
    @Autowired
    private TrangThaiChamCongRepository trangThaiChamCongRepository;

    public List<TrangThaiChamCongEntity> FindAll() {
        return trangThaiChamCongRepository.findAll();
    }

    public Optional<TrangThaiChamCongEntity> FindById(Long id) {
        return trangThaiChamCongRepository.findById(id);
    }

    public TrangThaiChamCongEntity Insert(TrangThaiChamCongEntity trangThaiChamCong) {
        return trangThaiChamCongRepository.save(trangThaiChamCong);
    }

    public TrangThaiChamCongEntity Update(TrangThaiChamCongEntity trangThaiChamCong) {
        return trangThaiChamCongRepository.save(trangThaiChamCong);
    }

    public void Delete(Long id) {
        trangThaiChamCongRepository.deleteById(id);
    }

    public List<TrangThaiChamCongEntity> GetAllActive() {
        return trangThaiChamCongRepository.GetAllActive();
    }
}
