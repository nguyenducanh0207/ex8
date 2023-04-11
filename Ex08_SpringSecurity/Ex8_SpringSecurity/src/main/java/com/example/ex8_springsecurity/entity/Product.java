package com.example.ex8_springsecurity.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "san_pham")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "ma_san_pham", nullable = false, length = 20)
    private String maSanPham;

    @NotNull(message = "invalid danh muc")
    @Column(name = "danh_muc", nullable = false)
    private Integer danhMuc;

    @NotNull(message = "invalid kho")
    @Column(name = "kho", nullable = false)
    private Integer kho;

    @NotNull
    @Max(100000000)
    @Column(name = "gia", nullable = false, precision = 10)
    private BigDecimal gia;

    @NotNull
    @Column(name = "ten_mota_sp", nullable = false, length = 50)
    private String tenMotaSp;

    @NotNull
    @Column(name = "duong_dan_anh")
    private String duongDanAnh;

    @NotNull
    @Column(name = "so_luong_sp")
    private Integer soLuongSp;

    @NotNull
    @Column(name = "so_luong_ban")
    private Integer soLuongBan;


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

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Integer getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(Integer danhMuc) {
        this.danhMuc = danhMuc;
    }

    public Integer getKho() {
        return kho;
    }

    public void setKho(Integer kho) {
        this.kho = kho;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getTenMotaSp() {
        return tenMotaSp;
    }

    public void setTenMotaSp(String tenMotaSp) {
        this.tenMotaSp = tenMotaSp;
    }

    public String getDuongDanAnh() {
        return duongDanAnh;
    }

    public void setDuongDanAnh(String duongDanAnh) {
        this.duongDanAnh = duongDanAnh;
    }

    public Integer getSoLuongSp() {
        return soLuongSp;
    }

    public void setSoLuongSp(Integer soLuongSp) {
        this.soLuongSp = soLuongSp;
    }

    public Integer getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(Integer soLuongBan) {
        this.soLuongBan = soLuongBan;
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