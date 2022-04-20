package com.example.demo.Controller;

import com.example.demo.Entity.DuAnEntity;
import com.example.demo.Service.DuAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin ("http://localhost:3000")
@RestController
@RequestMapping (value = "/api/duan")
public class DuAnController
{
	 @Autowired
	 private DuAnService duAnService;

	@CrossOrigin(origins = "http://localhost:3000")
	 @GetMapping ("")// Get danh sách
	 public List<DuAnEntity> getAll ()
	 {
		  return duAnService.GetAllActive();
	 }
	 
	 @GetMapping ("/{id}")// info 1 phần tử trong danh sách
	 public ResponseEntity<DuAnEntity> getById (@PathVariable Long id)
	 {
		  Optional<DuAnEntity> e = duAnService.FindById (id);
		  return e.map (duAnEntity -> new ResponseEntity<> (duAnEntity, HttpStatus.OK)).orElseGet (() -> new ResponseEntity<> (HttpStatus.NOT_FOUND));
	 }
	 
	 @PostMapping ("")// Thêm
	 public ResponseEntity<DuAnEntity> insert (@RequestBody DuAnEntity duAnEntity)
	 {
		  Long id = duAnService.Insert (duAnEntity).getDuAnId ();
		  Optional<DuAnEntity> e = duAnService.FindById (id);
		  return e.map (Entity -> new ResponseEntity<> (Entity, HttpStatus.OK)).orElseGet (() -> new ResponseEntity<> (HttpStatus.NOT_ACCEPTABLE));
	 }
	 
	 //
	 @PutMapping ("/{id}")// Cập nhật thông tin phần tử
	 public ResponseEntity<DuAnEntity> update (@PathVariable Long id, @RequestBody DuAnEntity duAnEntity)
	 {
		  Optional<DuAnEntity> e = duAnService.FindById (id);
		  if (e.isPresent ())
		  {
				duAnEntity.setDuAnId (id);
			  System.out.println("data:"+duAnEntity);
				return new ResponseEntity<> (duAnService.Update (duAnEntity), HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }

	 @CrossOrigin ("http://localhost:3000")
	 @PutMapping ("/remove/{id}")// Cập nhật lại status của phần tử
	 public ResponseEntity<DuAnEntity> remove (@PathVariable Long id)
	 {
		  Optional<DuAnEntity> e = duAnService.FindById (id);
		  if (e.isPresent ())
		  {
			  	e.get().setStatus (0);
				return new ResponseEntity<> (duAnService.Update (e.get()), HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }
	 
	 @DeleteMapping ("/{id}")// Xóa vĩnh viễn phần tử
	 public ResponseEntity<DuAnEntity> delete (@PathVariable Long id)
	 {
		  Optional<DuAnEntity> e = duAnService.FindById (id);
		  if (e.isPresent ())
		  {
				duAnService.Delete (id);
				return new ResponseEntity<> (HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }
}
