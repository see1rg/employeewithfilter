package com.see1rg.listofcars.service;


import com.see1rg.listofcars.model.entity.dto.RegisterReq;
import com.see1rg.listofcars.model.entity.dto.UserDto;

import java.security.Principal;
import java.util.Optional;

public interface UserService {

    Optional<UserDto> getUser(String name);

    RegisterReq update(RegisterReq user, Principal principal);

    RegisterReq save(RegisterReq newUser);
}