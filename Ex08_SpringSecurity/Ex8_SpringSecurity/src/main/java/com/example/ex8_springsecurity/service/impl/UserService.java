package com.example.ex8_springsecurity.service.impl;

import com.example.ex8_springsecurity.entity.UserEntity;
import com.example.ex8_springsecurity.repository.UserRepo;

import com.example.ex8_springsecurity.service.IUserServie;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("User")
public class UserService implements UserDetailsService,IUserServie{

    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByTaiKhoan(username);
        if (user == null)
        {
            throw new UsernameNotFoundException(username);

        }
        return new User(user.getTaiKhoan(),new BCryptPasswordEncoder().encode(user.getMatKhau()),new ArrayList<>());
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }

}
