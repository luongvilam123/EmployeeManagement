package com.example.demo.Service;

import com.example.demo.Entity.NhanVienDuAnEntity;
import com.example.demo.Entity.NhanVienEntity;
import com.example.demo.Repository.NhanVienDuAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienDuAnService {
    @Autowired
    private NhanVienDuAnRepository nhanVienDuAnRepository;

    public List<NhanVienDuAnEntity> FindAll() {
        return nhanVienDuAnRepository.findAll();
    }

    public Optional<NhanVienDuAnEntity> FindById(Long id) {
        return nhanVienDuAnRepository.findById(id);
    }

    public NhanVienDuAnEntity Insert(NhanVienDuAnEntity nhanVienDuAn) {
        return nhanVienDuAnRepository.save(nhanVienDuAn);
    }

    public NhanVienDuAnEntity Update(NhanVienDuAnEntity nhanVienDuAn) {
        return nhanVienDuAnRepository.save(nhanVienDuAn);
    }

    public void Delete(Long id) {
        nhanVienDuAnRepository.deleteById(id);
    }

    public List<NhanVienDuAnEntity> GetAllActive() {
        return nhanVienDuAnRepository.GetAllActive();
    }

    public List<NhanVienDuAnEntity> GetNVDAByNhanVien(Long id) {
        return nhanVienDuAnRepository.GetNVDAByNhanVien(id);
    }

    public void RemoveNVDAByNhanVien(Long nhanVienId) {
        nhanVienDuAnRepository.RemoveNVDAByNhanVien(nhanVienId);
    }

    public Optional<List<NhanVienEntity>> GetNVByDuAn(Long duAnId){
        return nhanVienDuAnRepository.GetNVByDuAn(duAnId);
    };

    public Optional<List<NhanVienEntity>> GetNVNotExits(Long id){
        return nhanVienDuAnRepository.GetNVNotExits(id);
    }

    public Optional<NhanVienDuAnEntity> CheckNVDA(Long id,Long nvid){
        return nhanVienDuAnRepository.CheckNVDA(id,nvid);
    }
}
