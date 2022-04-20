package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication
{
	 public static void main (String[] args)
	 {
		  SpringApplication.run (DemoApplication.class, args);
		 LocalDate now = LocalDate.now();
		 System.out.println(now);
		 LocalDate ngayTinhLuong = LocalDate.of(now.getYear(),now.getMonthValue(),1);
		 System.out.println(ngayTinhLuong);
		 ngayTinhLuong = ngayTinhLuong.minusDays(1);
		 System.out.println(ngayTinhLuong);
	 }
	 
}
