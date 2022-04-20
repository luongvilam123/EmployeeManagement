package com.example.demo.Entity;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "DuAn")
public class DuAnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DuAnId")
    private Long duAnId;

    @Column(name = "TenDuAn", nullable = false)
    private String tenDuAn;

    @Column(name = "ThuongDuAn", nullable = false)
    private Long thuongDuAn;

    @Column(name = "NgayBatDau", nullable = false)
    private LocalDate ngayBatDau;

    @Column(name = "NgayKetThuc", nullable = false)
    private LocalDate ngayKetThuc;

    @Column(name = "Status", columnDefinition = "int default 1", nullable = false)
    private Integer status=1;

    public DuAnEntity() {
    }

    public Long getDuAnId() {
        return duAnId;
    }

    public void setDuAnId(Long duAnId) {
        this.duAnId = duAnId;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public Long getThuongDuAn() {
        return thuongDuAn;
    }

    public void setThuongDuAn(Long thuongDuAn) {
        this.thuongDuAn = thuongDuAn;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DuAnEntity{" +
                "duAnId=" + duAnId +
                ", tenDuAn='" + tenDuAn + '\'' +
                ", thuongDuAn=" + thuongDuAn +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", status=" + status +
                '}';
    }
}
