package com.example.demo.Controller;

import com.example.demo.Entity.ChiTietNhanVienEntity;
import com.example.demo.Service.ChiTietNhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin ("http://localhost:3000")
@RestController
@RequestMapping(value = "/api/chitietnhanvien")
public class ChiTietNhanVienController
{
	 @Autowired
	 private ChiTietNhanVienService chiTietNhanVienService;

	 @GetMapping("")
	 public List<ChiTietNhanVienEntity> getAll() {
		  List<ChiTietNhanVienEntity> filter1 = new ArrayList<> ();
		  for (ChiTietNhanVienEntity cv : chiTietNhanVienService.FindAll()) {
				if (cv.getStatus() == 1) {
					 filter1.add(cv);
				}
		  }
		  return filter1;
	 }

	 @GetMapping("/{id}")
	 public ResponseEntity<ChiTietNhanVienEntity> getById(@PathVariable Long id) {
		  Optional<ChiTietNhanVienEntity> e = chiTietNhanVienService.FindById(id);
		  return e.map(chiTietNhanVienEntity -> new ResponseEntity<>(chiTietNhanVienEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }

	 public Optional<ChiTietNhanVienEntity> getByFK(Long id) {
		 return chiTietNhanVienService.GetByFK(id);
	 }

	 @PostMapping ("")
	 public ResponseEntity<ChiTietNhanVienEntity> insert(@RequestBody ChiTietNhanVienEntity chiTietNhanVienEntity) {
		  Long id = chiTietNhanVienService.Insert(chiTietNhanVienEntity).getChiTietNhanVienId();
		  Optional<ChiTietNhanVienEntity> e = chiTietNhanVienService.FindById(id);
//        System.out.println(e);
//		  System.out.println(e.map(chiTietNhanVienEntity1 -> new ResponseEntity<>(chiTietNhanVienEntity1, HttpStatus.OK)));
		  return e.map(chiTietNhanVienEntity1 -> new ResponseEntity<>(chiTietNhanVienEntity1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE));
	 }

	 public void update(ChiTietNhanVienEntity chiTietNhanVienEntity) {
		 chiTietNhanVienService.Update(chiTietNhanVienEntity);
	 }

	 @PutMapping ("/remove/{id}")
	 public ResponseEntity<ChiTietNhanVienEntity> remove(@PathVariable Long id, @RequestBody ChiTietNhanVienEntity chiTietNhanVienEntity) {
		  Optional<ChiTietNhanVienEntity> e = chiTietNhanVienService.FindById(id);
		  if (e.isPresent()) {
				chiTietNhanVienEntity.setChiTietNhanVienId(id);
				chiTietNhanVienEntity.setStatus(0);
				return new ResponseEntity<> (chiTietNhanVienService.Update(chiTietNhanVienEntity), HttpStatus.OK);
		  }
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }

	 @DeleteMapping ("/{id}")
	 public ResponseEntity<ChiTietNhanVienEntity> delete(@PathVariable Long id) {
		  Optional<ChiTietNhanVienEntity> e = chiTietNhanVienService.FindById(id);
		  if (e.isPresent()) {
				chiTietNhanVienService.Delete(id);
				return new ResponseEntity<>(HttpStatus.OK);
		  }
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
}
