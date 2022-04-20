package com.example.demo.Controller;

import com.example.demo.Entity.CongViecEntity;
import com.example.demo.Entity.NhanVienEntity;
import com.example.demo.Service.CongViecService;
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
@RequestMapping (value = "/api/congviec")
public class CongViecController
{
	 @Autowired
	 private CongViecService congViecService;
	 @Autowired
	 private NhanVienService nhanVienService;
	 
	 //    @GetMapping("/congviec/{id}")
//    public ResponseEntity<List<CongViecEntity>> findByCongViecId(@PathVariable Long id) {
//        Optional<CongViecEntity> list = congViecService.FindById(id);
//        if (!list.isEmpty()) {
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
//        }
//    }
	 
	 @CrossOrigin ("http://localhost:3000")
	 @GetMapping ("")
	 public List<CongViecEntity> getAll ()
	 {
//		  List<CongViecEntity> filter1 = new ArrayList<> ();
//		  for (CongViecEntity cv : congViecService.FindAll ())
//		  {
//				if (cv.getStatus () == 1)
//				{
//					 filter1.add (cv);
//				}
//		  }
//		  return filter1;
		 return congViecService.GetAllActive();
	 }

	 @GetMapping ("/{id}")
	 public ResponseEntity<CongViecEntity> getById (@PathVariable Long id)
	 {
		  Optional<CongViecEntity> e = congViecService.FindById (id);
		  return e.map (congViecEntity -> new ResponseEntity<> (congViecEntity, HttpStatus.OK)).orElseGet (() -> new ResponseEntity<> (HttpStatus.NOT_FOUND));
	 }

	@GetMapping ("/nvcongviec/{id}")
	public List<NhanVienEntity> getNhanVienByCongViec (@PathVariable Long id)
	{
		Optional<CongViecEntity> e = congViecService.FindById (id);
		List<NhanVienEntity> nvcv = new ArrayList<>();
		if (e.isPresent()) {
			nvcv = nhanVienService.GetNhanVienByCongViec(id);
			return nvcv;
		}
		return nvcv;
	}
	 
	 public CongViecEntity getCongViecById (Long id){
		  Optional<CongViecEntity> cv = congViecService.FindById (id);
		  return cv.get ();
	 }
	 
	 @PostMapping ("")
	 public ResponseEntity<CongViecEntity> insert (@RequestBody CongViecEntity congViecEntity)
	 {
		  Long id = congViecService.Insert (congViecEntity).getCongViecId ();
		  Optional<CongViecEntity> e = congViecService.FindById (id);
//        System.out.println(e);
//		  System.out.println (e.map (congViecEntity1 -> new ResponseEntity<> (congViecEntity1, HttpStatus.OK)));
		  return e.map (congViecEntity1 -> new ResponseEntity<> (congViecEntity1, HttpStatus.OK)).orElseGet (() -> new ResponseEntity<> (HttpStatus.NOT_ACCEPTABLE));
	 }
	 
	 //
	 @PutMapping ("/{id}")
	 public ResponseEntity<CongViecEntity> update (@PathVariable Long id, @RequestBody CongViecEntity congViecEntity)
	 {
		  Optional<CongViecEntity> e = congViecService.FindById (id);
		  if (e.isPresent ())
		  {
				congViecEntity.setCongViecId (id);
				return new ResponseEntity<> (congViecService.Update (congViecEntity), HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }
	 
	 @PutMapping ("/remove/{id}")
	 public ResponseEntity<CongViecEntity> remove (@PathVariable Long id, @RequestBody CongViecEntity congViecEntity)
	 {
		  Optional<CongViecEntity> e = congViecService.FindById (id);
		  if (e.isPresent ())
		  {
				congViecEntity.setCongViecId (id);
				congViecEntity.setStatus (0);
				return new ResponseEntity<> (congViecService.Update (congViecEntity), HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }
	 
	 @DeleteMapping ("/{id}")
	 public ResponseEntity<CongViecEntity> delete (@PathVariable Long id)
	 {
		  Optional<CongViecEntity> e = congViecService.FindById (id);
		  if (e.isPresent ())
		  {
				congViecService.Delete (id);
				return new ResponseEntity<> (HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }
}
