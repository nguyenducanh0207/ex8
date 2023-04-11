package com.example.ex8_springsecurity.repository;
import com.example.ex8_springsecurity.entity.WareHouse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WareHouseRepo extends JpaRepository<WareHouse,Integer> {
    WareHouse findOneById(int id);

    @Query(value = "call delete_kho_by_id(?1)" ,nativeQuery = true)
    int deleteById(int id);

    @Query("select w from WareHouse w where w.ten like %?1%")
    List<WareHouse> getByNamePage(String ten, Pageable pageable);
}
