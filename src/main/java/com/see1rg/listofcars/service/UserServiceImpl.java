package com.see1rg.listofcars.service;

import com.see1rg.listofcars.entity.User;
import com.see1rg.listofcars.entity.dto.RegisterReq;
import com.see1rg.listofcars.entity.dto.UserDto;
import com.see1rg.listofcars.exception.UserNotFoundException;
import com.see1rg.listofcars.mapper.UserMapper;
import com.see1rg.listofcars.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private static final Logger log = getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<UserDto> getUser(String email) {
        log.info("Get user: {}", email);
        User user = userRepository.findUserByUsername(email);
        UserDto userDto = userMapper.userToUserDto(user);
        return Optional.ofNullable(userDto);
    }

    @Override
    public RegisterReq update(RegisterReq user, Principal principal) {
        log.info("Update user: {}", principal);
        User optionalUser = userRepository.findUserByUsername(principal.getName());
        if (optionalUser == null) {
            throw new UserNotFoundException();
        }
        User updateUser = userMapper.updateUserFromRegisterReq(user, optionalUser);
        updateUser.setRole(optionalUser.getRole());
        updateUser.setId(optionalUser.getId());
        updateUser.setEmail(optionalUser.getEmail());
        userRepository.save(updateUser);
        return user;
    }

    @Override
    public RegisterReq save(RegisterReq user) {
        log.info("Save user: {}", user);
        User newUser = new User();
        newUser = userMapper.updateUserFromRegisterReq(user, newUser);
        userRepository.save(newUser);
        return user;
    }
}