package com.example.ex8_springsecurity.controller;


import com.example.ex8_springsecurity.entity.Product;
import com.example.ex8_springsecurity.service.BaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
public class ProductController {
    private final BaseService<Product> productService;

    public ProductController(@Qualifier("Product") BaseService<Product> productService) {
        this.productService = productService;
    }

    @GetMapping("/admin/products")
    public List<Product> getAll()
    {
        return  productService.getAll();
    }

    @GetMapping("/admin/product/{id}")
    public Product findById(@PathVariable @Valid int id)
    {
        return productService.findById(id);
    }

    @PostMapping("/admin/product")
    public Product create(@RequestBody @Valid Product product)
    {
        return productService.add(product);
    }

    @PutMapping("/admin/product/{id}")
    public Product update(@RequestBody @Valid Product product,@PathVariable @Valid int id)
    {
        return productService.updateById(product,id);
    }

    @DeleteMapping("/admin/product/{id}")
    public String delete(@PathVariable @Valid int id)
    {
        productService.deleteById(id);
        return "Delete Success";
    }
    @GetMapping("/admin/products/name")
    public List<Product> getAllProductsByName(@RequestParam("ten") String ten,
                                               @RequestParam(value = "page", required = false) Integer page,
                                               @RequestParam(value = "limit", required = false) Integer limit)
    {
        if (page != null && limit != null) {
            Pageable pageable = PageRequest.of(page - 1, limit);
            return productService.getAllByNamePage(ten, pageable);
        }else
        {
            return productService.getAllByNamePage(ten,null);
        }
    }

}
