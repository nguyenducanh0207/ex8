package com.example.ex8_springsecurity.controller;

import com.example.ex8_springsecurity.entity.WareHouse;
import com.example.ex8_springsecurity.service.BaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
public class WareHouseController {
    private final BaseService<WareHouse> wareHoueService;

    public WareHouseController(@Qualifier("WareHouse") BaseService<WareHouse> wareHoueService) {
        this.wareHoueService = wareHoueService;
    }

    @GetMapping("/admin/warehouses")
    public List<WareHouse> getAllCategories()
    {
        return wareHoueService.getAll();
    }

    @GetMapping("/admin/warehouse/{id}")
    public WareHouse findById(@PathVariable @Valid int id)
    {
        return wareHoueService.findById(id);
    }

    @PostMapping("/admin/warehouse")
    public WareHouse create(@RequestBody @Valid WareHouse wareHouse)
    {
        return wareHoueService.add(wareHouse);
    }

    @PutMapping("/admin/warehouse/{id}")
    public WareHouse updateById(@RequestBody @Valid WareHouse wareHouse, @PathVariable @Valid int id)
    {
        return wareHoueService.updateById(wareHouse, id);
    }

    @DeleteMapping("/admin/warehouse/delete/{id}")
    public String deleteById(@PathVariable @Valid int id)
    {
        wareHoueService.deleteById(id);
        return "Delete Success";
    }

    @GetMapping("/admin/warehouses/name")
    public List<WareHouse> getAllCategoriesByName(@RequestParam("ten") String ten,
                                                 @RequestParam(value = "page", required = false) Integer page,
                                                 @RequestParam(value = "limit", required = false) Integer limit)
    {
        if (page != null && limit != null) {
            Pageable pageable = PageRequest.of(page - 1, limit);
            return wareHoueService.getAllByNamePage(ten, pageable);
        }else
        {
            return wareHoueService.getAllByNamePage(ten,null);
        }
    }
}
