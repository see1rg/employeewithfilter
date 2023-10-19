package com.see1rg.listofcars.securities;

import com.see1rg.listofcars.entity.dto.SecurityUserDto;
import com.see1rg.listofcars.mapper.UserMapper;
import com.see1rg.listofcars.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MyUserDetails userDetails;

    public MyUserDetailsService(UserRepository userRepository, UserMapper userMapper, MyUserDetails userDetails) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userDetails = userDetails;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUserDto securityUserDto = userRepository.findByEmailIgnoreCase(username)
                .map(userMapper::toSecurityDto)
                .orElseThrow(() -> new UsernameNotFoundException("User %s not found".formatted(username)));
        userDetails.setUserDto(securityUserDto);
        return userDetails;
    }
}
