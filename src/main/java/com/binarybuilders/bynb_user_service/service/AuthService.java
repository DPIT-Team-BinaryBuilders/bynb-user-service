package com.binarybuilders.bynb_user_service.service;

import com.binarybuilders.bynb_user_service.dto.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
