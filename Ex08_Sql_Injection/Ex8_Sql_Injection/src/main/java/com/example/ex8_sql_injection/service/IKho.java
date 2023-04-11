package com.example.ex8_sql_injection.service;


import com.example.ex8_sql_injection.model.Kho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@EnableAutoConfiguration
@Service
public class IKho {

    private final JdbcTemplate jdbcTemplate;

    public IKho(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Khi chưa phòng chống sql injection ta sẽ truyền kiểu dữ liệu theo kiểu nối chuỗi.
    public List<Kho> getByNameDefault(String name) {
        String sql = "select * from kho where ten = "+"'"+name+"'";
        List<Kho> khos = this.jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Kho.class));
        return khos;
    }

    //Cách phòng chống chúng ta sẽ truyền theo kiểu param
    public List<Kho> getByName(String name) {
        String sql = "select * from kho where ten = ?";
        List <Kho> khos = this.jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Kho.class),new Object[]{name});
        return khos;
    }
}


