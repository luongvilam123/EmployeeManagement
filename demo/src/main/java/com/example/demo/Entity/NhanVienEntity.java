package com.example.demo.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "NhanVien")
public class NhanVienEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NhanVienId")
    private Long nhanVienId;

    @Column(name = "HoNhanVien", nullable = false)
    private String hoNhanVien;

    @Column(name = "TenNhanVien", nullable = false)
    private String tenNhanVien;

    @Column(name = "NgayVaoLam", nullable = false)
    private LocalDate ngayVaoLam;

    @Column(name = "LuongCanBan", nullable = false)
    private Long luongCanBan;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PhongBanId", nullable = false, foreignKey = @ForeignKey(name = "FK_NhanVien_PhongBan"))
    private PhongBanEntity phongBan;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ChucVuId", nullable = false, foreignKey = @ForeignKey(name = "FK_NhanVien_ChucVu"))
    private ChucVuEntity chucVu;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CongViecId", nullable = false, foreignKey = @ForeignKey(name = "FK_NhanVien_CongViec"))
    private CongViecEntity congViec;

    @Column(name = "Status", columnDefinition = "int default 1", nullable = false)
    private Integer status;

    public Long getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(Long nhanVienId) {
        this.nhanVienId = nhanVienId;
    }

    public String getHoNhanVien() {
        return hoNhanVien;
    }

    public void setHoNhanVien(String hoNhanVien) {
        this.hoNhanVien = hoNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(LocalDate ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public Long getLuongCanBan() {
        return luongCanBan;
    }

    public void setLuongCanBan(Long luongCanBan) {
        this.luongCanBan = luongCanBan;
    }

    public PhongBanEntity getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBanEntity phongBan) {
        this.phongBan = phongBan;
    }

    public ChucVuEntity getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVuEntity chucVu) {
        this.chucVu = chucVu;
    }

    public CongViecEntity getCongViec() {
        return congViec;
    }

    public void setCongViec(CongViecEntity congViec) {
        this.congViec = congViec;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public NhanVienEntity() {
    }

    @Override
    public String toString() {
        return "NhanVienEntity{" +
                "nhanVienId=" + nhanVienId +
                ", hoNhanVien='" + hoNhanVien +
                ", tenNhanVien='" + tenNhanVien +
                ", ngayVaoLam=" + ngayVaoLam +
                ", luongCanBan=" + luongCanBan +
                ", phongBan=" + phongBan +
                ", chucVu=" + chucVu +
                ", congViec=" + congViec +
                ", status=" + status +
                '}';
    }
}
