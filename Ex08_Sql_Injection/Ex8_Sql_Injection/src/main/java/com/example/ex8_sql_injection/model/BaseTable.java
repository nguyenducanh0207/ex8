package com.example.ex8_sql_injection.model;

import java.sql.Timestamp;

public abstract class BaseTable {
    public Long id;
    public Timestamp ngayTao;
    public Timestamp ngaySua;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
