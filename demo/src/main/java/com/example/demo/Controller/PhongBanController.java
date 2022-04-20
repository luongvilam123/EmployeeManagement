package com.example.demo.Controller;

import com.example.demo.Entity.NhanVienEntity;
import com.example.demo.Entity.PhongBanEntity;
import com.example.demo.Service.NhanVienService;
import com.example.demo.Service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin ("http://localhost:3000")
@RestController
@RequestMapping (value = "/api/phongban")
public class PhongBanController
{
	 @Autowired
	 private PhongBanService phongBanService;
	 @Autowired
	 private NhanVienService nhanVienService;
	 
	 @CrossOrigin ("http://localhost:3000")
	 @GetMapping ("")
	 public List<PhongBanEntity> getAll ()
	 {
		  return phongBanService.GetAllActive();
	 }
	 
	 @GetMapping ("/{id}")
	 public ResponseEntity<PhongBanEntity> getById (@PathVariable Long id)
	 {
		  Optional<PhongBanEntity> e = phongBanService.FindById (id);
		  return e.map (phongBanEntity -> new ResponseEntity<> (phongBanEntity, HttpStatus.OK)).orElseGet (() -> new ResponseEntity<> (HttpStatus.NOT_FOUND));
	 }
	 
	 public PhongBanEntity getPhongBanById (Long id){
		  Optional<PhongBanEntity> pb = phongBanService.FindById (id);
		  return pb.get ();
	 }

	@GetMapping ("/nvpb/{id}")
	public List<NhanVienEntity> getNhanVienByPb (@PathVariable Long id)
	{
		Optional<PhongBanEntity> e = phongBanService.FindById (id);
		List<NhanVienEntity> nvpb = new ArrayList<>();
		if (e.isPresent()) {
			nvpb = nhanVienService.GetNhanVienByPhongBan(id);
			return nvpb;
		}
		return nvpb;
	}

	 @PostMapping ("")
	 public ResponseEntity<PhongBanEntity> insert (@RequestBody PhongBanEntity phongBanEntity)
	 {
		  Long id = phongBanService.Insert (phongBanEntity).getPhongBanId ();
		  Optional<PhongBanEntity> e = phongBanService.FindById (id);
//        System.out.println(e);
//		  System.out.println (e.map (phongBanEntity1 -> new ResponseEntity<> (phongBanEntity1, HttpStatus.OK)));
		  return e.map (phongBanEntity1 -> new ResponseEntity<> (phongBanEntity1, HttpStatus.OK)).orElseGet (() -> new ResponseEntity<> (HttpStatus.NOT_ACCEPTABLE));
	 }
	 
	 //
	 @PutMapping ("/{id}")
	 public ResponseEntity<PhongBanEntity> update (@PathVariable Long id, @RequestBody PhongBanEntity phongBanEntity)
	 {
		  Optional<PhongBanEntity> e = phongBanService.FindById (id);
		  if (e.isPresent ())
		  {
				phongBanEntity.setPhongBanId (id);
				return new ResponseEntity<> (phongBanService.Update (phongBanEntity), HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }
	 
	 @PutMapping ("/remove/{id}")
	 public ResponseEntity<PhongBanEntity> remove (@PathVariable Long id, @RequestBody PhongBanEntity phongBanEntity)
	 {
		  Optional<PhongBanEntity> e = phongBanService.FindById (id);
		  if (e.isPresent ())
		  {
				phongBanEntity.setPhongBanId (id);
				phongBanEntity.setStatus (0);
				return new ResponseEntity<> (phongBanService.Update (phongBanEntity), HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }
	 
	 @DeleteMapping ("/{id}")
	 public ResponseEntity<PhongBanEntity> delete (@PathVariable Long id)
	 {
		  Optional<PhongBanEntity> e = phongBanService.FindById (id);
		  if (e.isPresent ())
		  {
				phongBanService.Delete (id);
				return new ResponseEntity<> (HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }
}
