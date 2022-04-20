package com.example.demo.Controller;

import com.example.demo.Entity.ChamCongEntity;
import com.example.demo.Entity.ChamCongThongKeDTO;
import com.example.demo.Entity.NhanVienEntity;
import com.example.demo.Entity.TrangThaiChamCongEntity;
import com.example.demo.Service.ChamCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin ("http://localhost:3000")
@RestController
@RequestMapping (value = "/api/chamcong")
public class ChamCongController
{
	 @Autowired
	 private ChamCongService chamCongService;
	 @Autowired
	 private NhanVienController nhanVienController;
	 @Autowired
	 private TrangThaiChamCongController trangThaiChamCongController;
	 
	 @CrossOrigin ("http://localhost:3000")
	 @GetMapping ("")
	 public List<ChamCongEntity> getAll ()
	 {
		  return chamCongService.GetAllActive ();
	 }
	 
	 @GetMapping ("/{id}")
	 public ResponseEntity<ChamCongEntity> getById (@PathVariable Long id)
	 {
		  Optional<ChamCongEntity> e = chamCongService.FindById (id);
		  return e.map (chamCongEntity -> new ResponseEntity<> (chamCongEntity, HttpStatus.OK)).orElseGet (() -> new ResponseEntity<> (HttpStatus.NOT_FOUND));
	 }
	 
	 public ChamCongEntity getChamCongById (Long id)
	 {
		  Optional<ChamCongEntity> cc = chamCongService.FindById (id);
		  return cc.get ();
	 }
	 
	 @GetMapping ("/thongke/{year}")
	 public List<?> getChamCongByYear (@PathVariable int year)
	 {
//		  LocalDate now = LocalDate.now ();
//		  int year = now.getYear ();
		  List<ChamCongEntity> ccs = chamCongService.GetChamCongByYear (year);
//		  System.out.println (ccs);
		  List<ChamCongThongKeDTO> ccThongKes = new ArrayList<> ();
		  int month = 1, soNgayLam, soNgayNghiCP, soNgayNghiKP;
		  ChamCongThongKeDTO ccThongKe;
		  while (month <= 12)
		  {
				soNgayLam = 0;
				soNgayNghiCP = 0;
				soNgayNghiKP = 0;
				for (ChamCongEntity cc : ccs)
				{
					 if (cc.getNgayChamCong ().getMonthValue () == month)
					 {
						  if (cc.getTrangThaiChamCong ().getTenTrangThai ().equals ("1"))
						  {
								soNgayLam++;
						  }
						  else if (cc.getTrangThaiChamCong ().getTenTrangThai ().equals ("2"))
						  {
								soNgayNghiCP++;
						  }
						  else if (cc.getTrangThaiChamCong ().getTenTrangThai ().equals ("3"))
						  {
								soNgayNghiKP++;
						  }
						  
					 }
				}
				ccThongKe = new ChamCongThongKeDTO ("Tháng " + month, soNgayLam, soNgayNghiCP, soNgayNghiKP);
				ccThongKes.add (ccThongKe);
				month++;
		  }
		  System.out.println (ccThongKes);
		  return ccThongKes;
	 }
	 
	 @PostMapping ("/capphat")
	 public List<ChamCongEntity> capPhat ()
	 {
		  ChamCongEntity chamCong;
		  TrangThaiChamCongEntity tt = trangThaiChamCongController.getTrangThaiChamCongById (1L);
		  LocalDate now = LocalDate.now ();
		  boolean existed = false;
		  List<ChamCongEntity> chamCongEntities = new ArrayList<> ();
		  for (NhanVienEntity nv : nhanVienController.getAll ())
		  {
				for (ChamCongEntity cc : chamCongService.GetChamCongByTime (now))
				{
					 if (cc.getNhanVien ().equals (nv))
					 {
						  existed = true;
						  if (cc.getStatus () == 0)
						  {
								cc.setTrangThaiChamCong (tt);
								cc.setStatus (1);
								chamCongService.Update (cc);
								chamCongEntities.add (cc);
						  }
						  break;
					 }
				}
				System.out.println ("======================");
				if (! existed)
				{
					 chamCong = new ChamCongEntity ();
					 chamCong.setNgayChamCong (now);
					 chamCong.setStatus (1);
					 chamCong.setNhanVien (nv);
					 chamCong.setTrangThaiChamCong (tt);
					 chamCongService.Insert (chamCong);
					 chamCongEntities.add (chamCong);
					 System.out.println (chamCong);
				}
				else
				{
					 existed = false;
				}
		  }
		  return chamCongEntities;
	 }

//	 @PostMapping ("")
//	 public ResponseEntity<ChamCongEntity> insert (@RequestBody ChamCongEntity chamCongEntity)
//	 {
//		  chamCongEntity.setNhanVien (nhanVienController.getNhanVienById (chamCongEntity.getNhanVien ().getNhanVienId ()));
//		  for (ChamCongEntity cc : chamCongService.GetChamCongByTime (chamCongEntity.getNgayChamCong ()))
//		  {
//				if (cc.getNhanVien ().equals (chamCongEntity.getNhanVien ()))
//				{
//					 return new ResponseEntity<> (HttpStatus.CONFLICT);
//				}
//		  }
//		  chamCongEntity.setTrangThaiChamCong (trangThaiChamCongController.getTrangThaiChamCongById (chamCongEntity.getTrangThaiChamCong ().getTrangThaiChamCongId ()));
//		  chamCongEntity.setStatus (1);
//		  Long id = chamCongService.Insert (chamCongEntity).getChamCongId ();
//		  Optional<ChamCongEntity> e = chamCongService.FindById (id);
//		  return e.map (chamCongEntity1 -> new ResponseEntity<> (chamCongEntity1, HttpStatus.OK)).orElseGet (() -> new ResponseEntity<> (HttpStatus.NOT_ACCEPTABLE));
//	 }
	 
	 public boolean insert (ChamCongEntity chamCongEntity, List<ChamCongEntity> chamCongsByTime)
	 {
//		chamCongEntity.setNhanVien (nhanVienController.getNhanVienById (chamCongEntity.getNhanVien ().getNhanVienId ()));
		  chamCongEntity.setStatus (1);
		  for (ChamCongEntity cc : chamCongsByTime)
		  {
				if (cc.getNhanVien ().toString ().equals (chamCongEntity.getNhanVien ().toString ()) && cc.getStatus () == 0)
				{
					 chamCongEntity.setChamCongId (cc.getChamCongId ());
					 chamCongService.Update (chamCongEntity);
					 System.out.println ("=== Update: " + chamCongEntity);
					 return true;
				}
				else if (cc.getNhanVien ().toString ().equals (chamCongEntity.getNhanVien ().toString ()) && cc.getStatus () == 1)
				{
					 System.out.println ("=== Fail!");
					 return false;
				}
		  }
		  System.out.println ("=== Insert: " + chamCongEntity);
		  chamCongService.Insert (chamCongEntity);
		  System.out.println ("=== Inserted: " + chamCongEntity);
		  return true;
	 }
	 
	 @PostMapping ("")
	 public List<ChamCongEntity> insertMulti (@RequestBody List<ChamCongEntity> chamCongEntities)
	 {
		  List<ChamCongEntity> chamCongsSuccess = new ArrayList<> ();
		  List<ChamCongEntity> chamCongsByTime = chamCongService.GetChamCongByTime (chamCongEntities.get (0).getNgayChamCong ());
		  System.out.println ("=== Nhan vien da cham cong " + chamCongEntities.get (0).getNgayChamCong () + ": " + chamCongsByTime);
		  for (ChamCongEntity cc : chamCongEntities)
		  {
				if (insert (cc, chamCongsByTime))
				{
					 chamCongsSuccess.add (cc);
				}
		  }
		  System.out.println ("=== Success: " + chamCongsSuccess);
		  return chamCongsSuccess;
//        return new ResponseEntity<>(chamCongEntity, HttpStatus.OK);
	 }
	 
	 //
	 @PutMapping ("/{id}")
	 public ResponseEntity<ChamCongEntity> update (@PathVariable Long id, @RequestBody ChamCongEntity chamCongEntity)
	 {
		  Optional<ChamCongEntity> e = chamCongService.FindById (id);
		  if (e.isPresent ())
		  {
				chamCongEntity.setChamCongId (id);
				chamCongEntity.setNhanVien (nhanVienController.getNhanVienById (chamCongEntity.getNhanVien ().getNhanVienId ()));
				chamCongEntity.setTrangThaiChamCong (trangThaiChamCongController.getTrangThaiChamCongById (chamCongEntity.getTrangThaiChamCong ().getTrangThaiChamCongId ()));
				chamCongEntity.setStatus (1);
				return new ResponseEntity<> (chamCongService.Update (chamCongEntity), HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }
	 
	 @PutMapping ("/remove/{id}")
	 public ResponseEntity<ChamCongEntity> remove (@PathVariable Long id, @RequestBody ChamCongEntity chamCongEntity)
	 {
		  Optional<ChamCongEntity> e = chamCongService.FindById (id);
		  if (e.isPresent ())
		  {
				chamCongEntity.setChamCongId (id);
				chamCongEntity.setStatus (0);
				return new ResponseEntity<> (chamCongService.Update (chamCongEntity), HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }
	 
	 @DeleteMapping ("/{id}")
	 public ResponseEntity<ChamCongEntity> delete (@PathVariable Long id)
	 {
		  Optional<ChamCongEntity> e = chamCongService.FindById (id);
		  if (e.isPresent ())
		  {
				chamCongService.Delete (id);
				return new ResponseEntity<> (HttpStatus.OK);
		  }
		  return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	 }
}
