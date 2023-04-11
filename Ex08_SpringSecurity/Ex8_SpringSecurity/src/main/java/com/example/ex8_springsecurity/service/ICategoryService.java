package com.example.ex8_springsecurity.service;

import com.example.ex8_springsecurity.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll(Pageable pageable);
    int totalItem();
}
