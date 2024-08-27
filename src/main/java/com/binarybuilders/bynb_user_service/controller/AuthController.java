package com.binarybuilders.bynb_user_service.controller;

import com.binarybuilders.bynb_user_service.dto.AuthResponseDto;
import com.binarybuilders.bynb_user_service.dto.LoginDto;
import com.binarybuilders.bynb_user_service.dto.UserDto;
import com.binarybuilders.bynb_user_service.service.AuthService;
import com.binarybuilders.bynb_user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;
    private AuthService authService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public void saveUser(@RequestBody UserDto user){
        userService.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> Login(@RequestBody LoginDto loginDto) {
        //01 - Receive the token from AuthService
        String token = authService.login(loginDto);

        //02 - Set the token as a response using JwtAuthResponse Dto class
        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setAccessToken(token);

        //03 - Return the response to the user
        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
    }

}
