package com.binarybuilders.bynb_user_service.controller;

import com.binarybuilders.bynb_user_service.dto.AuthResponseDto;
import com.binarybuilders.bynb_user_service.dto.LoginDto;
import com.binarybuilders.bynb_user_service.dto.UserDto;
import com.binarybuilders.bynb_user_service.persistence.UserEntity;
import com.binarybuilders.bynb_user_service.service.AuthService;
import com.binarybuilders.bynb_user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public Iterable<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(UserEntity user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(Long id){
        userService.deleteUser(id);
    }

}