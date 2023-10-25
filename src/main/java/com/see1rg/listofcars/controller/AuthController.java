package com.see1rg.listofcars.controller;

import com.see1rg.listofcars.model.entity.Role;
import com.see1rg.listofcars.model.entity.dto.LoginReq;
import com.see1rg.listofcars.model.entity.dto.RegisterReq;
import com.see1rg.listofcars.service.AuthService;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:8080")
public class AuthController {

    private final AuthService authService;

    private static final Logger log = getLogger(AuthController.class);

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@NotBlank @RequestBody LoginReq req) {

        log.info("Login user: {} password: {}", req.getUsername(), req.getPassword());

        if (authService.login(req.getUsername(), req.getPassword())) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @PostMapping("/register")
    public ResponseEntity<Void> register(@NotBlank @RequestBody RegisterReq req) {

        log.info("Register user: {} role: {}", req.getUsername(), req.getRole());
        Role role = req.getRole() == null ? Role.LIST_VIEW : req.getRole();

        if (authService.register(req, role)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

//    @PostMapping("/logout")
//    public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//
//        // Дополнительная логика для завершения сеанса пользователя, если необходимо
//
//        // После успешного выхода, вы можете вернуть успешный статус.
//        return ResponseEntity.ok().build();
//    }
}
