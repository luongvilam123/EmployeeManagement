package com.example.demo.Controller;

import com.example.demo.Entity.ChiTietNhanVienEntity;
import com.example.demo.Entity.NhanVienChiTietDTO;
import com.example.demo.Entity.NhanVienEntity;
import com.example.demo.Service.ChamCongService;
import com.example.demo.Service.LuongService;
import com.example.demo.Service.NhanVienDuAnService;
import com.example.demo.Service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin ("http://localhost:3000")
@RestController
@RequestMapping(value = "/api/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private ChiTietNhanVienController chiTietNhanVienController;
    @Autowired
    private PhongBanController phongBanController;
    @Autowired
    private ChucVuController chucVuController;
    @Autowired
    private CongViecController congViecController;
    @Autowired
    private ChamCongService chamCongService;
    @Autowired
    private NhanVienDuAnService nhanVienDuAnService;
    @Autowired
    private LuongService luongService;
    
    @GetMapping("")
    public List<NhanVienEntity> getAll() {
        return nhanVienService.GetAllActive();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<NhanVienEntity> getById(@PathVariable Long id) {
        Optional<NhanVienEntity> e = nhanVienService.FindById(id);
        return e.map(nhanVienEntity -> new ResponseEntity<>(nhanVienEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public NhanVienEntity getNhanVienById(Long id) {
        Optional<NhanVienEntity> e = nhanVienService.FindById(id);
        return e.get();
    }
    
    @PostMapping ("")
    public ResponseEntity<NhanVienEntity> insert(@RequestBody NhanVienChiTietDTO nhanVienChiTietDTO) {
        nhanVienChiTietDTO.getNhanVien ().setPhongBan (phongBanController.getPhongBanById (nhanVienChiTietDTO.getPhongBanId ()));
        nhanVienChiTietDTO.getNhanVien ().setChucVu (chucVuController.getChucVuById (nhanVienChiTietDTO.getChucVuId ()));
        nhanVienChiTietDTO.getNhanVien ().setCongViec (congViecController.getCongViecById (nhanVienChiTietDTO.getCongViecId ()));
        nhanVienChiTietDTO.getNhanVien ().setStatus (1);
        Long id = nhanVienService.Insert(nhanVienChiTietDTO.getNhanVien ()).getNhanVienId();
        Optional<NhanVienEntity> e = nhanVienService.FindById(id);
        if (e.isPresent ()){
            nhanVienChiTietDTO.getChiTietNhanVien ().setNhanVien (e.get ());
            nhanVienChiTietDTO.getChiTietNhanVien ().setStatus (1);
            ResponseEntity<ChiTietNhanVienEntity> ctnv = chiTietNhanVienController.insert (nhanVienChiTietDTO.getChiTietNhanVien ());
            if (ctnv.getStatusCode ().value () != 200){
                nhanVienService.Delete (id);
            }
//        System.out.println(e)
        };
//        System.out.println(e.map(nhanVienEntity1 -> new ResponseEntity<>(nhanVienEntity1, HttpStatus.OK)));
        return e.map(a -> new ResponseEntity<>(a, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<NhanVienEntity> update(@PathVariable Long id, @RequestBody NhanVienChiTietDTO nhanVienChiTietDTO) {
        Optional<NhanVienEntity> e = nhanVienService.FindById(id);
        Optional<ChiTietNhanVienEntity> ctnv = chiTietNhanVienController.getByFK(id);
        if (e.isPresent() && ctnv.isPresent()) {
            nhanVienChiTietDTO.getNhanVien().setNhanVienId(id);
            nhanVienChiTietDTO.getChiTietNhanVien().setChiTietNhanVienId(ctnv.get().getChiTietNhanVienId());
            nhanVienChiTietDTO.getNhanVien ().setPhongBan (phongBanController.getPhongBanById (nhanVienChiTietDTO.getPhongBanId ()));
            nhanVienChiTietDTO.getNhanVien ().setChucVu (chucVuController.getChucVuById (nhanVienChiTietDTO.getChucVuId ()));
            nhanVienChiTietDTO.getNhanVien ().setCongViec (congViecController.getCongViecById (nhanVienChiTietDTO.getCongViecId ()));
            nhanVienChiTietDTO.getNhanVien ().setStatus (1);
            nhanVienChiTietDTO.getChiTietNhanVien ().setNhanVien (nhanVienChiTietDTO.getNhanVien ());
            nhanVienChiTietDTO.getChiTietNhanVien ().setStatus (1);
            if (!nhanVienChiTietDTO.getNhanVien().toString().equals(e.get().toString())) {
                nhanVienService.Update(nhanVienChiTietDTO.getNhanVien());
            }
            if (!nhanVienChiTietDTO.getChiTietNhanVien().toString().equals(ctnv.get().toString())) {
                chiTietNhanVienController.update(nhanVienChiTietDTO.getChiTietNhanVien());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping ("/remove/{id}")
    public ResponseEntity<NhanVienEntity> remove(@PathVariable Long id) {
        Optional<NhanVienEntity> e = nhanVienService.FindById(id);
        Optional<ChiTietNhanVienEntity> ctnv = chiTietNhanVienController.getByFK(id);
        if (e.isPresent() && ctnv.isPresent()) {
            e.get().setStatus(0);
            ctnv.get().setStatus(0);
            nhanVienService.Update(e.get());
            chiTietNhanVienController.update(ctnv.get());
            chamCongService.RemoveChamCongByNhanVien(id);
            nhanVienDuAnService.RemoveNVDAByNhanVien(id);
            luongService.RemoveLuongByNhanVien(id);
            return new ResponseEntity<> (HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping ("/{id}")
    public ResponseEntity<NhanVienEntity> delete(@PathVariable Long id) {
        Optional<NhanVienEntity> e = nhanVienService.FindById(id);
        Optional<ChiTietNhanVienEntity> ctnv = chiTietNhanVienController.getByFK(id);
        if (e.isPresent() && ctnv.isPresent()) {
            nhanVienService.Delete(id);
            chiTietNhanVienController.delete(ctnv.get().getChiTietNhanVienId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
