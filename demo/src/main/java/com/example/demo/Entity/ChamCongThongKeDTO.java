package com.example.demo.Entity;

public class ChamCongThongKeDTO
{
	 private String month;
	 private int soNgayDiLam;
	 private int soNgayNghiCP;
	 private int soNgayNghiKP;
	 
	 public ChamCongThongKeDTO ()
	 {
	 }
	 
	 public ChamCongThongKeDTO (String month, int soNgayDiLam, int soNgayNghiCP, int soNgayNghiKP)
	 {
		  this.month = month;
		  this.soNgayDiLam = soNgayDiLam;
		  this.soNgayNghiCP = soNgayNghiCP;
		  this.soNgayNghiKP = soNgayNghiKP;
	 }
	 
	 public String getMonth ()
	 {
		  return month;
	 }
	 
	 public void setMonth (String month)
	 {
		  this.month = month;
	 }
	 
	 public int getSoNgayDiLam ()
	 {
		  return soNgayDiLam;
	 }
	 
	 public void setSoNgayDiLam (int soNgayDiLam)
	 {
		  this.soNgayDiLam = soNgayDiLam;
	 }
	 
	 public int getSoNgayNghiCP ()
	 {
		  return soNgayNghiCP;
	 }
	 
	 public void setSoNgayNghiCP (int soNgayNghiCP)
	 {
		  this.soNgayNghiCP = soNgayNghiCP;
	 }
	 
	 public int getSoNgayNghiKP ()
	 {
		  return soNgayNghiKP;
	 }
	 
	 public void setSoNgayNghiKP (int soNgayNghiKP)
	 {
		  this.soNgayNghiKP = soNgayNghiKP;
	 }
	 
	 @Override
	 public String toString ()
	 {
		  return "ChamCongThongKeDTO{" +
					"month=" + month +
					", soNgayDiLam=" + soNgayDiLam +
					", soNgayNghiCP=" + soNgayNghiCP +
					", soNgayNghiKP=" + soNgayNghiKP +
					'}';
	 }
}
