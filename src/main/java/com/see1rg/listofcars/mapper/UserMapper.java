package com.see1rg.listofcars.mapper;

import com.see1rg.listofcars.model.entity.User;
import com.see1rg.listofcars.model.entity.dto.RegisterReq;
import com.see1rg.listofcars.model.entity.dto.SecurityUserDto;
import com.see1rg.listofcars.model.entity.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {
    UserDto userToUserDto(User user);
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "email", ignore = true)
    User userDtoToUser(UserDto userDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password",ignore = true)
    User updateUserFromRegisterReq(RegisterReq registerReq);

    SecurityUserDto toSecurityDto(User user);

}
