package com.example.demo.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "ChamCong")
public class ChamCongEntity
{
	 @Id
	 @GeneratedValue (strategy = GenerationType.IDENTITY)
	 @Column (name = "ChamCongId")
	 private Long chamCongId;
	 
	 @Column (name = "NgayChamCong", nullable = false)
	 private LocalDate ngayChamCong;
	 
	 @ManyToOne (optional = false)
	 @JoinColumn (name = "NhanVienId", foreignKey = @ForeignKey (name = "FK_ChamCong_NhanVien"))
	 private NhanVienEntity nhanVien;
	 
	 @ManyToOne (optional = false)
	 @JoinColumn (name = "TrangThaiChamCongId", foreignKey = @ForeignKey (name = "FK_ChamCong_TrangThaiChamCong"))
	 private TrangThaiChamCongEntity trangThaiChamCong;
	 
	 @Column (name = "Status", columnDefinition = "int default 1", nullable = false)
	 private Integer status;
	 
	 public ChamCongEntity ()
	 {
	 }
	 
	 public Long getChamCongId ()
	 {
		  return chamCongId;
	 }
	 
	 public void setChamCongId (Long chamCongId)
	 {
		  this.chamCongId = chamCongId;
	 }
	 
	 public LocalDate getNgayChamCong ()
	 {
		  return ngayChamCong;
	 }
	 
	 public void setNgayChamCong (LocalDate ngayChamCong)
	 {
		  this.ngayChamCong = ngayChamCong;
	 }
	 
	 public NhanVienEntity getNhanVien ()
	 {
		  return nhanVien;
	 }
	 
	 public void setNhanVien (NhanVienEntity nhanVien)
	 {
		  this.nhanVien = nhanVien;
	 }
	 
	 public TrangThaiChamCongEntity getTrangThaiChamCong ()
	 {
		  return trangThaiChamCong;
	 }
	 
	 public void setTrangThaiChamCong (TrangThaiChamCongEntity trangThaiChamCong)
	 {
		  this.trangThaiChamCong = trangThaiChamCong;
	 }
	 
	 public Integer getStatus ()
	 {
		  return status;
	 }
	 
	 public void setStatus (Integer status)
	 {
		  this.status = status;
	 }
	 
	 @Override
	 public String toString ()
	 {
		  return "ChamCongEntity{" +
					"chamCongId=" + chamCongId +
					", ngayChamCong=" + ngayChamCong +
					", nhanVien=" + nhanVien +
					", trangThaiChamCong=" + trangThaiChamCong +
					", status=" + status +
					"}\n";
	 }
}
