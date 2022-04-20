package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table (name = "TrangThaiChamCong")
public class TrangThaiChamCongEntity
{
	 @Id
	 @GeneratedValue (strategy = GenerationType.IDENTITY)
	 @Column (name = "TrangThaiChamCongId")
	 private Long trangThaiChamCongId;
	 
	 @Column (name = "TenTrangThai", nullable = false, unique = true)
	 private String tenTrangThai;
	 
	 @Column (name = "Status", columnDefinition = "int default 1", nullable = false)
	 private Integer status;
	 
	 public TrangThaiChamCongEntity ()
	 {
	 }
	 
	 public Long getTrangThaiChamCongId ()
	 {
		  return trangThaiChamCongId;
	 }
	 
	 public void setTrangThaiChamCongId (Long trangThaiChamCongId)
	 {
		  this.trangThaiChamCongId = trangThaiChamCongId;
	 }
	 
	 public String getTenTrangThai ()
	 {
		  return tenTrangThai;
	 }
	 
	 public void setTenTrangThai (String tenTrangThai)
	 {
		  this.tenTrangThai = tenTrangThai;
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
		  return "TrangThaiChamCongEntity{" +
					"trangThaiChamCongId=" + trangThaiChamCongId +
					", tenTrangThai='" + tenTrangThai + '\'' +
					", status=" + status +
					'}';
	 }
}
