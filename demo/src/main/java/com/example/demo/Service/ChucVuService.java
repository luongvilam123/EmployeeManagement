package com.example.demo.Service;

import com.example.demo.Entity.ChucVuEntity;
import com.example.demo.Repository.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChucVuService {
    @Autowired
    private ChucVuRepository chucVuRepository;

    public List<ChucVuEntity> FindAll() {
        return chucVuRepository.findAll();
    }

    public Optional<ChucVuEntity> FindById(Long id) {
        return chucVuRepository.findById(id);
    }

    public ChucVuEntity Insert(ChucVuEntity chucVu) {
        return chucVuRepository.save(chucVu);
    }

    public ChucVuEntity Update(ChucVuEntity chucVu) {
        return chucVuRepository.save(chucVu);
    }

    public void Delete(Long id) {
        chucVuRepository.deleteById(id);
    }

    public List<ChucVuEntity> GetAllActive() {
        return chucVuRepository.GetAllActive();
    }
}
