package com.example.ex8_springsecurity.service.impl;


import com.example.ex8_springsecurity.entity.Category;
import com.example.ex8_springsecurity.repository.CategoryRepo;
import com.example.ex8_springsecurity.service.BaseService;
import com.example.ex8_springsecurity.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;


@Service("Category")
public class CategoryService implements BaseService<Category>, ICategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public List <Category> findAll(Pageable pageable) {
        return categoryRepo.get All(pageable);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category add(Category category) {
        category.setNgaySua(Timestamp.valueOf(java.time.LocalDateTime.now()));
        category.setNgayTao(Timestamp.valueOf(java.time.LocalDateTime.now()));
        return categoryRepo.save(category);
    }

    @Override
    public Category updateById(Category category, int id) {
        if(categoryRepo.findOneById(id) != null)
        {
            category.setId(id);
            category.setNgaySua(Timestamp.valueOf(java.time.LocalDateTime.now()));
            category.setNgayTao(categoryRepo.findOneById(id).getNgayTao());
            categoryRepo.save(category);
            return category;
        }
        else {
            return null;
        }
    }

    @Override
    public Category findById(int id) {
        return  categoryRepo.findOneById(id);
    }

    @Override
    public void deleteById(int id) {
        if(categoryRepo.findOneById(id) != null)
        {
            categoryRepo.deleteById(id);
        }
    }

    @Override
    public List<Category> getAllByNamePage(String ten, Pageable pageable)
    {

        return categoryRepo.getByNamePage(ten, pageable);
    }
    @Override
    public int totalItem()
    {
        return (int) categoryRepo.count();
    }
}
