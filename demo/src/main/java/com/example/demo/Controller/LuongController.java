package com.example.demo.Controller;

import com.example.demo.Entity.ChamCongEntity;
import com.example.demo.Entity.LuongEntity;
import com.example.demo.Entity.NhanVienDuAnEntity;
import com.example.demo.Entity.NhanVienEntity;
import com.example.demo.Service.ChamCongService;
import com.example.demo.Service.LuongService;
import com.example.demo.Service.NhanVienDuAnService;
import com.example.demo.Service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin ("http://localhost:3000")
@RestController
@RequestMapping (value = "/api/luong")
public class LuongController
{
	 @Autowired
	 private LuongService luongService;
	 @Autowired
	 private NhanVienService nhanVienService;
	 @Autowired
	 private ChamCongService chamCongService;
	 @Autowired
	 private NhanVienDuAnService nhanVienDuAnService;
	 
	 @CrossOrigin ("http://localhost:3000")
	 @GetMapping ("")
	 public List<LuongEntity> getAll ()
	 {
		  return luongService.GetAllActive ();
	 }
	 
	 @PostMapping ("/tinhluong")
	 public ResponseEntity<?> calculatorLuong ()
	 {
		  List<LuongEntity> luongCal = new ArrayList<> ();
		  // check list NV
		  List<NhanVienEntity> nvLuong = nhanVienService.GetAllActive ();
		  if (nvLuong.size () == 0 || nvLuong.isEmpty ())
		  {
				System.out.println ("Không thể tính lương! Danh sách nhân viên rỗng.");
				return new ResponseEntity<String> ("Fail", HttpStatus.OK);
		  }
		  // TÍNH LƯƠNG CỦA THÁNG TRƯỚC NẾU NGÀY HÔM NAY LÀ NGÀY ĐẦU TIÊN CỦA THÁNG MỚI
		  LocalDate now = LocalDate.now ();
		  // Nếu không là ngày đầu của tháng thì không tính
//        if (now.getDayOfMonth() != 1){
//            System.out.println("Không thể tính lương! Hôm nay không phải ngày đầu tiên của tháng.");
//            return;
//        }
		  
		  // Điều chỉnh thành ngày cuối cùng của tháng trước
		  LocalDate ngayTinhLuong = LocalDate.of (now.getYear (), now.getMonthValue (), 1);
		  ngayTinhLuong = ngayTinhLuong.minusDays (1);
		  
		  // Nếu tháng trước đã tính thì không tính nữa
		  if (luongService.GetLuongByTime (ngayTinhLuong.getMonthValue (), ngayTinhLuong.getYear ()).size () > 0)
		  {
				System.out.println ("Đã tính lương tháng trước!");
				return new ResponseEntity<String> ("Conflict", HttpStatus.OK);
		  }
		  
		  LuongEntity luong;
		  int ngayLam, ngayNghiCP, ngayNghiKP;
		  long thuongDuAn;
		  double luongNgay, luongThucLanh;
		  
		  // Calculator
		  for (NhanVienEntity nv : nvLuong)
		  {
				luong = new LuongEntity ();
				luong.setStatus (1);
				luong.setNhanVien (nv);
				// ngày tính lương
				luong.setNgayTinhLuong (ngayTinhLuong);
				// lương căn bản
				luong.setLuongCanBan (nv.getLuongCanBan ());
				// hệ số
				luong.setHeSoChucVu (nv.getChucVu ().getHeSoChucVu ());
				luong.setHeSoCongViec (nv.getCongViec ().getHeSoCongViec ());
				// số ngày làm, nghỉ CP, nghỉ KP
				ngayLam = 0;
				ngayNghiCP = 0;
				ngayNghiKP = 0;
				List<ChamCongEntity> ccByNv = chamCongService.GetChamCongByNhanVien (nv.getNhanVienId (), ngayTinhLuong.getMonthValue (), ngayTinhLuong.getYear ());
				for (ChamCongEntity cc : ccByNv)
				{
					 if (cc.getTrangThaiChamCong ().getTrangThaiChamCongId () == 1)
					 {
						  ngayLam++;
					 }
					 else if (cc.getTrangThaiChamCong ().getTrangThaiChamCongId () == 2)
					 {
						  ngayNghiCP++;
					 }
					 else if (cc.getTrangThaiChamCong ().getTrangThaiChamCongId () == 3)
					 {
						  ngayNghiKP++;
					 }
				}
				luong.setSoNgayLam (ngayLam);
				luong.setSoNgayNghiCP (ngayNghiCP);
				luong.setSoNgayNghiKP (ngayNghiKP);
				// dự án
				thuongDuAn = 0;
				List<NhanVienDuAnEntity> nvdaByNv = nhanVienDuAnService.GetNVDAByNhanVien (nv.getNhanVienId ());
				for (NhanVienDuAnEntity nvda : nvdaByNv)
				{
					 if (nvda.getDuAn ().getNgayKetThuc ().getMonth ().equals (ngayTinhLuong.getMonth ())
							  && nvda.getDuAn ().getNgayKetThuc ().getYear () == ngayTinhLuong.getYear ()
							  && nvda.getDuAn ().getNgayKetThuc ().isBefore (ngayTinhLuong))
					 {
						  thuongDuAn += nvda.getDuAn ().getThuongDuAn ();
					 }
				}
				luong.setThuongDuAn (thuongDuAn);
				// lương ngày theo hệ số công việc/ chức vụ
				luongNgay = (luong.getLuongCanBan () / 26) * (1 + luong.getHeSoChucVu () + luong.getHeSoCongViec ());
				// lương thực lãnh
				// tổng số ngày làm/nghỉ CP/nghỉ KP
				int totalDays = luong.getSoNgayLam () + luong.getSoNgayNghiCP () + luong.getSoNgayNghiKP ();
				// lương theo ngày làm = (lương ngày * 26 ngày) - (lương ngày * số ngày nghỉ CP * hệ số CP) - (lương ngày * số ngày nghỉ KP * hệ số KP)
				luongThucLanh = (luongNgay * totalDays) - (luongNgay * luong.getSoNgayNghiCP () * 1.0) - (luongNgay * luong.getSoNgayNghiKP () * 1.5);
				// cộng tiền thưởng dự án kết thúc trong tháng đó
				luongThucLanh += luong.getThuongDuAn ();
				luong.setLuongThucLanh ((long) luongThucLanh);
				luongService.Insert (luong);
				System.out.println (luong);
				luongCal.add (luong);
		  }
		  return new ResponseEntity<> (luongCal, HttpStatus.OK);
	 }
}
