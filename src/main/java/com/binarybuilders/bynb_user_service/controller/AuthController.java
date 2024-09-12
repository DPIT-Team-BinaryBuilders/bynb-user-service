package com.binarybuilders.bynb_user_service.controller;

import com.binarybuilders.bynb_user_service.dto.AuthResponseDto;
import com.binarybuilders.bynb_user_service.dto.LoginDto;
import com.binarybuilders.bynb_user_service.dto.UserDto;
import com.binarybuilders.bynb_user_service.persistence.UserEntity;
import com.binarybuilders.bynb_user_service.repository.UserRepository;
import com.binarybuilders.bynb_user_service.service.AuthService;
import com.binarybuilders.bynb_user_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> saveUser(@RequestBody UserDto user){
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> Login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authService.login(loginDto));
    }

}
