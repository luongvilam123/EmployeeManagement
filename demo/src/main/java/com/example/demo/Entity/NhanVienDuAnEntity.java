package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table (name = "NhanVienDuAn")
public class NhanVienDuAnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NhanVienDuAnId")
    private Long nhanVienDuAnId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "DuAnId", nullable = false, foreignKey = @ForeignKey(name = "FK_NhanVienDuAn_DuAn"))
    private DuAnEntity duAn;

    @ManyToOne(optional = false)
    @JoinColumn(name = "NhanVienId", nullable = false, foreignKey = @ForeignKey(name = "FK_NhanVienDuAn_NhanVien"))
    private NhanVienEntity nhanVien;

    @Column(name = "Status", columnDefinition = "int default 1", nullable = false)
    private Integer status=1;

    public NhanVienDuAnEntity() {
    }

    public Long getNhanVienDuAnId() {
        return nhanVienDuAnId;
    }

    public void setNhanVienDuAnId(Long nhanVienDuAnId) {
        this.nhanVienDuAnId = nhanVienDuAnId;
    }

    public DuAnEntity getDuAn() {
        return duAn;
    }

    public void setDuAn(DuAnEntity duAn) {
        this.duAn = duAn;
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
        return "NhanVienDuAnEntity{" +
                "nhanVienDuAnId=" + nhanVienDuAnId +
                ", duAn=" + duAn +
                ", nhanVien=" + nhanVien +
                ", status=" + status +
                '}';
    }


}
