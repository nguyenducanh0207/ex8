package com.example.ex8_springsecurity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "kho")
public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "ma_kho", nullable = false, length = 20)
    private String maKho;

    @NotNull
    @Column(name = "ten", nullable = false, length = 20)
    private String ten;

    @NotNull
    @Column(name = "dia_diem", nullable = false, length = 50)
    private String diaDiem;


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

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
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