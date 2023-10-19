package com.see1rg.listofcars.controller;

import com.see1rg.listofcars.entity.Role;
import com.see1rg.listofcars.entity.dto.LoginReq;
import com.see1rg.listofcars.entity.dto.RegisterReq;
import com.see1rg.listofcars.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginReq req) {

        if (authService.login(req.getUsername(), req.getPassword())) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterReq req) {
        Role role = req.getRole() == null ? Role.LIST_VIEW : req.getRole();

        if (authService.register(req, role)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
