package com.example.demo.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "Luong")
public class LuongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LuongId")
    private Long luongId;

    @Column(name = "LuongCanBan", nullable = false)
    private Long luongCanBan;

    @Column(name = "NgayTinhLuong", nullable = false)
    private LocalDate ngayTinhLuong;

    @Column(name = "HeSoChucVu", nullable = false)
    private Double heSoChucVu;

    @Column(name = "HeSoCongViec", nullable = false)
    private Double heSoCongViec;

    @Column(name = "SoNgayLam", nullable = false)
    private Integer soNgayLam;

    @Column(name = "SoNgayNghiCP", nullable = false)
    private Integer soNgayNghiCP;

    @Column(name = "SoNgayNghiKP", nullable = false)
    private Integer soNgayNghiKP;

    @Column(name = "ThuongDuAn", nullable = false)
    private Long thuongDuAn;

    @Column(name = "LuongThucLanh", nullable = false)
    private Long luongThucLanh;

    @ManyToOne(optional = false)
    @JoinColumn(name = "NhanVienId", foreignKey = @ForeignKey(name = "FK_Luong_NhanVien"))
    private NhanVienEntity nhanVien;

    @Column(name = "Status", columnDefinition = "int default 1", nullable = false)
    private Integer status;

    public LuongEntity() {
    }

    public Long getLuongId() {
        return luongId;
    }

    public void setLuongId(Long luongId) {
        this.luongId = luongId;
    }

    public Long getLuongCanBan() {
        return luongCanBan;
    }

    public void setLuongCanBan(Long luongCanBan) {
        this.luongCanBan = luongCanBan;
    }

    public LocalDate getNgayTinhLuong() {
        return ngayTinhLuong;
    }

    public void setNgayTinhLuong(LocalDate ngayTinhLuong) {
        this.ngayTinhLuong = ngayTinhLuong;
    }

    public Double getHeSoChucVu() {
        return heSoChucVu;
    }

    public void setHeSoChucVu(Double heSoChucVu) {
        this.heSoChucVu = heSoChucVu;
    }

    public Double getHeSoCongViec() {
        return heSoCongViec;
    }

    public void setHeSoCongViec(Double heSoCongViec) {
        this.heSoCongViec = heSoCongViec;
    }

    public Integer getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(Integer soNgayLam) {
        this.soNgayLam = soNgayLam;
    }

    public Integer getSoNgayNghiCP() {
        return soNgayNghiCP;
    }

    public void setSoNgayNghiCP(Integer soNgayNghiCP) {
        this.soNgayNghiCP = soNgayNghiCP;
    }

    public Integer getSoNgayNghiKP() {
        return soNgayNghiKP;
    }

    public void setSoNgayNghiKP(Integer soNgayNghiKP) {
        this.soNgayNghiKP = soNgayNghiKP;
    }

    public Long getThuongDuAn() {
        return thuongDuAn;
    }

    public void setThuongDuAn(Long thuongDuAn) {
        this.thuongDuAn = thuongDuAn;
    }

    public Long getLuongThucLanh() {
        return luongThucLanh;
    }

    public void setLuongThucLanh(Long luongThucLanh) {
        this.luongThucLanh = luongThucLanh;
    }

    public NhanVienEntity getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVienEntity nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LuongEntity{" +
                "luongId=" + luongId +
                ", luongCanBan=" + luongCanBan +
                ", ngayTinhLuong=" + ngayTinhLuong +
                ", heSoChucVu=" + heSoChucVu +
                ", heSoCongViec=" + heSoCongViec +
                ", soNgayLam=" + soNgayLam +
                ", soNgayNghiCP=" + soNgayNghiCP +
                ", soNgayNghiKP=" + soNgayNghiKP +
                ", thuongDuAn=" + thuongDuAn +
                ", luongThucLanh=" + luongThucLanh +
                ", nhanVien=" + nhanVien +
                ", status=" + status +
                '}';
    }
}
