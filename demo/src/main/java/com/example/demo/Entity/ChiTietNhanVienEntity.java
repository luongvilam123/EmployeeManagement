package com.example.demo.Entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "ChiTietNhanVien")
public class ChiTietNhanVienEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChiTietNhanVienId")
    private Long chiTietNhanVienId;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "Sdt", nullable = false)
    private String sdt;

    @Column(name = "Mail", nullable = false)
    private String mail;

    @Column(name = "GioiTinh", nullable = false)
    private Integer gioiTinh;

    @Column(name = "NgaySinh", nullable = false)
    private LocalDate ngaySinh;

    @Column(name = "NoiSinh", nullable = false)
    private String noiSinh;

    @Column(name = "DiaChi", nullable = false)
    private String diaChi;

    @Column(name = "CanCuoc", nullable = false)
    private String canCuoc;

    @Column(name = "NgayCap", nullable = false)
    private LocalDate ngayCap;

    @OneToOne(optional = false)
    @JoinColumn(name = "NhanVienId", foreignKey = @ForeignKey(name = "FK_ChiTietNhanVien_NhanVien"))
    private NhanVienEntity nhanVien;

    @Column(name = "Status", columnDefinition = "int default 1", nullable = false)
    private Integer status;

    public ChiTietNhanVienEntity() {
    }

    public Long getChiTietNhanVienId() {
        return chiTietNhanVienId;
    }

    public void setChiTietNhanVienId(Long chiTietNhanVienId) {
        this.chiTietNhanVienId = chiTietNhanVienId;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCanCuoc() {
        return canCuoc;
    }

    public void setCanCuoc(String canCuoc) {
        this.canCuoc = canCuoc;
    }

    public LocalDate getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(LocalDate ngayCap) {
        this.ngayCap = ngayCap;
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
        return "ChiTietNhanVienEntity{" +
                "chiTietNhanVienId=" + chiTietNhanVienId +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", sdt='" + sdt + '\'' +
                ", mail='" + mail + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", ngaySinh=" + ngaySinh +
                ", noiSinh='" + noiSinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", canCuoc='" + canCuoc + '\'' +
                ", ngayCap=" + ngayCap +
                ", nhanVien=" + nhanVien +
                ", status=" + status +
                '}';
    }
}
