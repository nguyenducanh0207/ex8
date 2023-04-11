package com.example.ex8_springsecurity.controller;


import com.example.ex8_springsecurity.entity.Category;
import com.example.ex8_springsecurity.service.BaseService;
import com.example.ex8_springsecurity.service.ICategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class CategoryController {
    private final BaseService<Category> categoryService;
    private final ICategoryService iCategoryService;

    public CategoryController(@Qualifier("Category") BaseService<Category> categoryService, ICategoryService iCategoryService) {
        this.categoryService = categoryService;
        this.iCategoryService = iCategoryService;
    }

    @GetMapping("/admin/categories")
    public List <Category> getAllCategories(@RequestParam(value = "page", required = false) Integer page,
                                           @RequestParam(value = "limit", required = false) Integer limit)
    {
        if (page != null && limit != null) {
            Pageable pageable = PageRequest.of(page - 1, limit);
            return iCategoryService.findAll(pageable);
        }else
        {
            return iCategoryService.findAll(null);
        }
    }

    @GetMapping("/admin/category/{id}")
    public Category findById(@PathVariable @Valid int id)
    {
        return categoryService.findById(id);
    }

    @PostMapping("/admin/category")
    public Category create(@RequestBody @Valid Category category)
    {
        return categoryService.add(category);
    }

    @PutMapping("/admin/category/{id}")
    public Category updateById(@RequestBody @Valid Category category, @PathVariable @Valid int id)
    {
            return categoryService.updateById(category, id);
    }

    @DeleteMapping("/admin/category/delete/{id}")
    public String deleteById(@PathVariable @Valid int id)
    {
        categoryService.deleteById(id);
        return "Delete Success";
    }

    @GetMapping("/admin/categories/name")
    public List<Category> getAllCategoriesByName(@RequestParam("ten") String ten,
                                                @RequestParam(value = "page", required = false) Integer page,
                                                @RequestParam(value = "limit", required = false) Integer limit)
    {
        if (page != null && limit != null) {
            Pageable pageable = PageRequest.of(page - 1, limit);
            return categoryService.getAllByNamePage(ten, pageable);
        }else
        {
            return categoryService.getAllByNamePage(ten,null);
        }
    }
    @GetMapping("/admin/total-item")
    public int getToTalItem()
    {
        return iCategoryService.totalItem();
    }

}
