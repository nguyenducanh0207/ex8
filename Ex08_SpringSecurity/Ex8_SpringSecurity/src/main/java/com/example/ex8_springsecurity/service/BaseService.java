package com.example.ex8_springsecurity.service;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<T> {
    List<T> getAll();
    T add(T t);
    T updateById(T t,int id);
    T findById(int id);
    void deleteById(int id);
    List<T> getAllByNamePage(String ten, Pageable pageable);

}
