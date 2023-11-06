package com.see1rg.listofcars.service;


import com.see1rg.listofcars.mapper.UserMapper;
import com.see1rg.listofcars.model.entity.Role;
import com.see1rg.listofcars.model.entity.User;
import com.see1rg.listofcars.model.entity.dto.NewPasswordDto;
import com.see1rg.listofcars.model.entity.dto.RegisterReq;
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
    private final UserMapper userMapper;

    private static final Logger log = getLogger(AuthServiceImpl.class);

    public AuthServiceImpl(MyUserDetailsService manager, PasswordEncoder encoder, UserService userService, UserRepository userRepository, UserMapper userMapper) {
        this.manager = manager;
        this.encoder = encoder;
        this.userService = userService;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public boolean login(String userName, String password) {
        if (userRepository.findUserByUsername(userName) == null) {
            log.info("User {} not found", userName);
            return false;
        }
        UserDetails userDetails = manager.loadUserByUsername(userName);
        return encoder.matches(password, userDetails.getPassword());
    }

    @Override
    public boolean register(RegisterReq registerReq, Role role) {
        if (userRepository.findUserByUsername(registerReq.getUsername()) != null) {
            log.info("User {} already exists, skipping registration for this user", registerReq.getUsername());
            return false;
        }

        User newUser = new User();
        newUser = userMapper.updateUserFromRegisterReq(registerReq, newUser);
        newUser.setPassword(encoder.encode(registerReq.getPassword()));
        userService.save(newUser);

        return true;
    }

    @Override
    public boolean changePassword(NewPasswordDto newPasswordDto, String userName) {
        log.info("Change password for user: {}", userName);
        User user = userRepository.findByUsernameIgnoreCase(userName).orElseThrow(UserNotFoundException::new);

        if (encoder.matches(newPasswordDto.getNewPassword(), user.getPassword())) {
            user.setPassword(encoder.encode(newPasswordDto.getNewPassword()));
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
