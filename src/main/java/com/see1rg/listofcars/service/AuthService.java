package com.see1rg.listofcars.service;

import com.see1rg.listofcars.model.entity.Role;
import com.see1rg.listofcars.model.entity.dto.NewPasswordDto;
import com.see1rg.listofcars.model.entity.dto.RegisterReq;

public interface AuthService {
    boolean login(String userName, String password);
    boolean register(RegisterReq registerReq, Role role);
    boolean changePassword(NewPasswordDto newPasswordDto, String userName);
}
