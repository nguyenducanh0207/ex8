package com.example.ex8_springsecurity.controller;

import com.example.ex8_springsecurity.entity.Product;
import com.example.ex8_springsecurity.entity.UserEntity;
import com.example.ex8_springsecurity.security.jwt.JwtRequest;
import com.example.ex8_springsecurity.security.jwt.JwtResponse;
import com.example.ex8_springsecurity.security.jwt.JwtTokenUtil;
import com.example.ex8_springsecurity.service.IUserServie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
@CrossOrigin("http://localhost:3000")
@RestController
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService jwtInMemoryUserDetailsService;
    private final IUserServie userServie;

    public UserController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, @Qualifier("User") UserDetailsService jwtInMemoryUserDetailsService, IUserServie userServie) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtInMemoryUserDetailsService = jwtInMemoryUserDetailsService;
        this.userServie=userServie;

    }

    @PostMapping(value = "/admin/login")
    public ResponseEntity<?> generateAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtInMemoryUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @GetMapping("/admin/users")
    public List<UserEntity> getAll()
    {
        return userServie.getAll();
    }
}
