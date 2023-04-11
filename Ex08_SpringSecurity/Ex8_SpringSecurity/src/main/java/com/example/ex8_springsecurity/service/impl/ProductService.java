package com.example.ex8_springsecurity.service.impl;


import com.example.ex8_springsecurity.entity.Category;
import com.example.ex8_springsecurity.entity.Product;
import com.example.ex8_springsecurity.entity.WareHouse;
import com.example.ex8_springsecurity.repository.CategoryRepo;
import com.example.ex8_springsecurity.repository.ProductRepo;
import com.example.ex8_springsecurity.repository.WareHouseRepo;
import com.example.ex8_springsecurity.service.BaseService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;


@Service("Product")
public class ProductService implements BaseService<Product> {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final WareHouseRepo wareHouseRepo;

    public ProductService(ProductRepo productRepo, CategoryRepo categoryRepo, WareHouseRepo wareHouseRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
        this.wareHouseRepo = wareHouseRepo;
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product add(Product product) {
        Category category = categoryRepo.findOneById(product.getDanhMuc());
        WareHouse wareHouse = wareHouseRepo.findOneById(product.getKho());
        if(category.getId() != null && wareHouse.getId()!= null)
        {
            product.setDanhMuc(category.getId());
            product.setKho(wareHouse.getId());
            product.setNgaySua(Timestamp.valueOf(java.time.LocalDateTime.now()));
            product.setNgayTao(Timestamp.valueOf(java.time.LocalDateTime.now()));
            return productRepo.save(product);
        }else {
            return null;
        }
    }
    @Override
    public Product updateById(Product product ,int id) {
        Category category = categoryRepo.findOneById(product.getDanhMuc());
        WareHouse wareHouse = wareHouseRepo.findOneById(product.getKho());
        if (productRepo.findOneById(id) != null && category.getId() != null && wareHouse.getId()!= null)
        {
            product.setId(id);
            product.setDanhMuc(category.getId());
            product.setKho(wareHouse.getId());
            product.setNgaySua(Timestamp.valueOf(java.time.LocalDateTime.now()));
            product.setNgayTao(productRepo.findOneById(id).getNgayTao());
            productRepo.save(product);
            return product;
        }
        else{
            return null;
        }
    }

    @Override
    public Product findById(int id) {

        return productRepo.findOneById(id);
    }


    @Override
    public void deleteById(int id) {
        if(productRepo.findById(id) != null)
        {
            productRepo.deleteById(id);
        }
    }

    @Override
    public List<Product> getAllByNamePage(String ten, Pageable pageable)
    {

        return productRepo.getByNamePage(ten, pageable);
    }
}
