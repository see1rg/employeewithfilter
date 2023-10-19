package com.see1rg.listofcars.service;


import com.see1rg.listofcars.entity.Role;
import com.see1rg.listofcars.entity.User;
import com.see1rg.listofcars.entity.dto.NewPasswordDto;
import com.see1rg.listofcars.entity.dto.RegisterReq;
import com.see1rg.listofcars.exception.UserNotFoundException;
import com.see1rg.listofcars.repository.UserRepository;
import com.see1rg.listofcars.securities.MyUserDetailsService;
import org.slf4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.slf4j.LoggerFactory.getLogger;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final MyUserDetailsService manager;

    private final PasswordEncoder encoder;

    private final UserService userService;

    private final UserRepository userRepository;
    private static final Logger log = getLogger(AuthServiceImpl.class);

    public AuthServiceImpl(MyUserDetailsService manager, PasswordEncoder encoder, UserService userService, UserRepository userRepository) {
        this.manager = manager;
        this.encoder = encoder;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(String userName, String password) {
        if (userRepository.findUserByUsername(userName) == null) {
            log.info("Пользователь с именем {} не найден", userName);
            return false;
        }
        UserDetails userDetails = manager.loadUserByUsername(userName);
        return encoder.matches(password, userDetails.getPassword());
    }

    @Override
    public boolean register(RegisterReq registerReq, Role role) {
        if (userRepository.findUserByUsername(registerReq.getUsername()) != null) {
            log.info("Пользователь с именем {} уже существует", registerReq.getUsername());
            return false;
        }

        log.info("Register user: {} role: {}", registerReq, role);
        RegisterReq newUser = new RegisterReq();
        newUser.setUsername(registerReq.getUsername());
        newUser.setPassword(encoder.encode(registerReq.getPassword()));
        newUser.setFullName(registerReq.getFullName());
        newUser.setRole(role);
        userService.save(newUser);

        return true;
    }

    @Override
    public boolean changePassword(NewPasswordDto newPasswordDto, String userName) {
        log.info("Change password for user: {}", userName);
        User user = userRepository.findByEmailIgnoreCase(userName).orElseThrow(UserNotFoundException::new);
        if (encoder.matches(newPasswordDto.getNewPassword(), user.getPassword())) {
            user.setPassword(encoder.encode(newPasswordDto.getNewPassword()));
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
