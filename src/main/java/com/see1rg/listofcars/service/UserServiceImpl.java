package com.see1rg.listofcars.service;

import com.see1rg.listofcars.model.entity.User;
import com.see1rg.listofcars.model.entity.dto.RegisterReq;
import com.see1rg.listofcars.model.entity.dto.UserDto;
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
    @Transactional
    public RegisterReq update(RegisterReq user, Principal principal) {
        log.info("Update user: {}", principal);
        User optionalUser = userRepository.findUserByUsername(principal.getName());

        if (optionalUser == null) {
            throw new UserNotFoundException();
        }

        User updateUser = userMapper.updateUserFromRegisterReq(user);
        updateUser.setId(optionalUser.getId());
        userRepository.save(updateUser);

        return user;
    }

    @Override
    @Transactional
    public void save(User user) {
        log.info("Save user: {}", user);
        userRepository.save(user);
    }
}