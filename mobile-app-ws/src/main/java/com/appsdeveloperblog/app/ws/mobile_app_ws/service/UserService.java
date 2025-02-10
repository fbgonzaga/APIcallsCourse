package com.appsdeveloperblog.app.ws.mobile_app_ws.service;

import com.appsdeveloperblog.app.ws.mobile_app_ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
    UserDto getUser(String email);
    UserDto getUserByUserId(String userId);
}
