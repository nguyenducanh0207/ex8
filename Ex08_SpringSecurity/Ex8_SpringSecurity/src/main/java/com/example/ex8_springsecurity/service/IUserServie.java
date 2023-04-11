package com.example.ex8_springsecurity.service;

import com.example.ex8_springsecurity.entity.UserEntity;

import java.util.List;

public interface IUserServie {
    List<UserEntity> getAll();
}
