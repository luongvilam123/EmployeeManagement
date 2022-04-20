package com.example.demo.Controller;

import com.example.demo.Entity.DuAnEntity;
import com.example.demo.Entity.NhanVienDuAnEntity;
import com.example.demo.Entity.NhanVienEntity;
import com.example.demo.Service.DuAnService;
import com.example.demo.Service.NhanVienDuAnService;
import com.example.demo.Service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping (value = "/api/nhanvienduan")
@CrossOrigin(origins= "http://localhost:3000")
public class NhanVienDuAnController
{
	 @Autowired
	 private NhanVienDuAnService nhanVienDuAnService;
	 @Autowired
	 private DuAnService duAnService;
	 @Autowired
	 private NhanVienService nhanVienService;

	 @GetMapping ("")// Get danh sách
	 public List<NhanVienDuAnEntity> getAll ()
	 {
		  return nhanVienDuAnService.GetAllActive();
	 }
	 
//	 @GetMapping ("/{id}")// info 1 phần tử trong danh sách
//	 public ResponseEntity<NhanVienDuAnEntity> getById (@PathVariable Long id)
//	 {
//		  Optional<NhanVienDuAnEntity> e = nhanVienDuAnService.FindById (id);
//		  return e.map (nhanVienDuAnEntity -> new ResponseEntity<> (nhanVienDuAnEntity, HttpStatus.OK)).orElseGet (() -> new ResponseEntity<> (HttpStatus.NOT_FOUND));
//	 }

	@GetMapping ("/them/{id}")// info 1 phần tử trong danh sách
	public ResponseEntity<List<NhanVienEntity>> getNVNotExits (@PathVariable Long id)
	{
		Optional<List<NhanVienEntity>> e = nhanVienDuAnService.GetNVNotExits(id);
		return e.map (nhanVienDuAnEntity -> new ResponseEntity<> (nhanVienDuAnEntity, HttpStatus.OK)).orElseGet (() -> new ResponseEntity<> (HttpStatus.NOT_FOUND));
	}

	@GetMapping ("/{id}")// info 1 phần tử trong danh sách
	public ResponseEntity<List<NhanVienEntity>> getNVByDA (@PathVariable Long id)
	{
		Optional<List<NhanVienEntity>> e = nhanVienDuAnService.GetNVByDuAn(id);
		return e.map (nhanVienDuAnEntity -> new ResponseEntity<> (nhanVienDuAnEntity, HttpStatus.OK)).orElseGet (() -> new ResponseEntity<> (HttpStatus.NOT_FOUND));
	}

	 @PostMapping ("/add/{id}")// Thêm
	 public List<NhanVienEntity> insert (@PathVariable Long id, @RequestBody List<NhanVienEntity> nhanVienEntity)
	 {
		 List<NhanVienEntity> reponse = new ArrayList<>();
		 Optional<DuAnEntity> nvda = duAnService.FindById(id);
		 if(nvda.isPresent()){
			 for(NhanVienEntity a : nhanVienEntity){
				 Optional<NhanVienDuAnEntity> e = nhanVienDuAnService.CheckNVDA (id,a.getNhanVienId());
				 if(!e.isPresent()){
					 NhanVienDuAnEntity nvdaTemp = new NhanVienDuAnEntity();
					 nvdaTemp.setNhanVien(new NhanVienEntity());
					 nvdaTemp.getNhanVien().setNhanVienId(a.getNhanVienId());
					 nvdaTemp.setDuAn(new DuAnEntity());
					 nvdaTemp.getDuAn().setDuAnId(id);

					 NhanVienDuAnEntity temp = nhanVienDuAnService.Insert(nvdaTemp);
					 Optional<NhanVienEntity> nvTemp = nhanVienService.FindById(a.getNhanVienId());
					 reponse.add( nvTemp.get());
				 }
			 }
		 }
//		  Long id = nhanVienDuAnService.Insert (nhanVienDuAnEntity).getNhanVienDuAnId();
		 System.out.println("Hello OUTSIDE");
		  return reponse;
	 }


	 @PutMapping ("/{id}")// Cập nhật thông tin phần tử
	 public ResponseEntity<NhanVienDuAnEntity> update (@PathVariable Long id, @RequestBody NhanVienDuAnEntity nhanVienDuAnEntity)
	 {
		  Optional<NhanVienDuAnEntity> e = nhanVienDuAnService.FindById (id);
		  if (e.isPresent ())
		  {
				nhanVienDuAnEntity.setNhanVienDuAnId(id);
				return new ResponseEntity<> (nhanVienDuAnService.Update (nhanVienDuAnEntity), HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }

	 @PutMapping ("/remove/{id}")// Cập nhật lại status của phần tử
	 public ResponseEntity<NhanVienDuAnEntity> remove (@PathVariable Long id,@RequestBody NhanVienEntity nhanVienEntity)
	 {
		 System.out.println("Nhân viên: "+ nhanVienEntity);
		  Optional<NhanVienDuAnEntity> e = nhanVienDuAnService.CheckNVDA (id,nhanVienEntity.getNhanVienId());
		 System.out.println(e.get());
		  if (e.isPresent ())
		  {
			  e.get().setStatus(0);
				return new ResponseEntity<> (nhanVienDuAnService.Update (e.get()), HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }
	 
	 @DeleteMapping ("/{id}")// Xóa vĩnh viễn phần tử
	 public ResponseEntity<NhanVienDuAnEntity> delete (@PathVariable Long id)
	 {
		  Optional<NhanVienDuAnEntity> e = nhanVienDuAnService.FindById (id);
		  if (e.isPresent ())
		  {
				nhanVienDuAnService.Delete (id);
				return new ResponseEntity<> (HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }
}
