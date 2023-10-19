package com.see1rg.listofcars.controller;

import com.see1rg.listofcars.model.entity.Role;
import com.see1rg.listofcars.model.entity.dto.LoginReq;
import com.see1rg.listofcars.model.entity.dto.RegisterReq;
import com.see1rg.listofcars.service.AuthService;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.slf4j.LoggerFactory.getLogger;

//@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    private static Logger log = getLogger(AuthController.class);

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginReq req) {

        log.info("Login user: {} password: {}", req.getUsername(), req.getPassword());

        if (authService.login(req.getUsername(), req.getPassword())) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterReq req) {

        log.info("Register user: {} role: {}", req.getUsername(), req.getRole());

        Role role = req.getRole() == null ? Role.LIST_VIEW : req.getRole();

        if (authService.register(req, role)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
