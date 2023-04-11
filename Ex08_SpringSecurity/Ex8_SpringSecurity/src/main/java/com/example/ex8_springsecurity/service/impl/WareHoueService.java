package com.example.ex8_springsecurity.service.impl;


import com.example.ex8_springsecurity.entity.WareHouse;
import com.example.ex8_springsecurity.repository.WareHouseRepo;
import com.example.ex8_springsecurity.service.BaseService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service("WareHouse")
public class WareHoueService implements BaseService<WareHouse> {
    private final WareHouseRepo wareHouseRepo;

    public WareHoueService(WareHouseRepo wareHouseRepo) {
        this.wareHouseRepo = wareHouseRepo;
    }

    @Override
    public List<WareHouse> getAll() {
        return wareHouseRepo.findAll();
    }

    @Override
    public WareHouse add(WareHouse wareHouse) {
        wareHouse.setNgaySua(Timestamp.valueOf(java.time.LocalDateTime.now()));
        wareHouse.setNgayTao(Timestamp.valueOf(java.time.LocalDateTime.now()));
        return wareHouseRepo.save(wareHouse);
    }

    @Override
    public WareHouse updateById(WareHouse wareHouse, int id) {
        if(wareHouseRepo.findOneById(id) != null)
        {
            wareHouse.setId(id);
            wareHouse.setNgaySua(Timestamp.valueOf(java.time.LocalDateTime.now()));
            wareHouse.setNgayTao(wareHouseRepo.findOneById(id).getNgayTao());
            wareHouseRepo.save(wareHouse);
            return wareHouse;
        }
        else {
            return null;
        }
    }

    @Override
    public WareHouse findById(int id) {
        return wareHouseRepo.findOneById(id);
    }

    @Override
    public void deleteById(int id) {
        if(wareHouseRepo.findOneById(id) != null)
        {
            wareHouseRepo.deleteById(id);
        }
    }

    @Override
    public List<WareHouse> getAllByNamePage(String ten, Pageable pageable) {
        return wareHouseRepo.getByNamePage(ten, pageable);
    }
}
