package com.example.demo.Entity;

public class NhanVienChiTietDTO
{
	 private NhanVienEntity nhanVien;
	 private ChiTietNhanVienEntity chiTietNhanVien;
	 private Long phongBanId;
	 private Long chucVuId;
	 private Long congViecId;
	 
	 public NhanVienEntity getNhanVien ()
	 {
		  return nhanVien;
	 }
	 
	 public void setNhanVien (NhanVienEntity nhanVien)
	 {
		  this.nhanVien = nhanVien;
	 }
	 
	 public ChiTietNhanVienEntity getChiTietNhanVien ()
	 {
		  return chiTietNhanVien;
	 }
	 
	 public void setChiTietNhanVien (ChiTietNhanVienEntity chiTietNhanVien)
	 {
		  this.chiTietNhanVien = chiTietNhanVien;
	 }
	 
	 public Long getPhongBanId ()
	 {
		  return phongBanId;
	 }
	 
	 public void setPhongBanId (Long phongBanId)
	 {
		  this.phongBanId = phongBanId;
	 }
	 
	 public Long getChucVuId ()
	 {
		  return chucVuId;
	 }
	 
	 public void setChucVuId (Long chucVuId)
	 {
		  this.chucVuId = chucVuId;
	 }
	 
	 public Long getCongViecId ()
	 {
		  return congViecId;
	 }
	 
	 public void setCongViecId (Long congViecId)
	 {
		  this.congViecId = congViecId;
	 }
}
