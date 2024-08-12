package com.binarybuilders.bynb_user_service.controller;

import com.binarybuilders.bynb_user_service.messaging.DangerMessage;
import com.binarybuilders.bynb_user_service.persistence.UserEntity;
import com.binarybuilders.bynb_user_service.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;

    }

    @PostMapping("/create")
    public UserEntity saveUser(UserEntity user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(Long id){
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

    @PostMapping("/create_danger")
    public void createDanger(@RequestBody DangerMessage dangerMessage){
        System.out.println("Danger message received");
        userService.sendDangerMessage(dangerMessage);
    }

    @GetMapping("/1")
    public String ads(@RequestBody String siaus){
        System.out.println("Danger message received");
        return 1 + siaus;
    }


}
