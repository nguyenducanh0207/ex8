package com.example.ex8_springsecurity.repository;

import com.example.ex8_springsecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    @Query("select u from UserEntity u where u.taiKhoan = ?1")
    UserEntity findByTaiKhoan (String taiKhoan);
}
