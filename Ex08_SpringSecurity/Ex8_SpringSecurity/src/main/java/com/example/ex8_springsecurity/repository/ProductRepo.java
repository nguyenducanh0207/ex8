package com.example.ex8_springsecurity.repository;



import com.example.ex8_springsecurity.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    Product findOneById(int id);

    @Query("select p from Product p where p.tenMotaSp like %?1%")
    List<Product> getByNamePage(String ten, Pageable pageable);
}
