package com.example.ex8_springsecurity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "loai_danh_muc")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "ma_loai_danh_muc", nullable = false, length = 20)
    private String maLoaiDanhMuc;

    @NotNull
    @Column(name = "ten", nullable = false, length = 20)
    private String ten;

    @NotNull
    @Column(name = "mo_ta", nullable = false, length = 20)
    private String moTa;


    @Column(name = "ngay_tao")
    private Timestamp ngayTao;


    @Column(name = "ngay_sua")
    private Timestamp ngaySua;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaLoaiDanhMuc() {
        return maLoaiDanhMuc;
    }

    public void setMaLoaiDanhMuc(String maLoaiDanhMuc) {
        this.maLoaiDanhMuc = maLoaiDanhMuc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Timestamp getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Timestamp getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Timestamp ngaySua) {
        this.ngaySua = ngaySua;
    }

}