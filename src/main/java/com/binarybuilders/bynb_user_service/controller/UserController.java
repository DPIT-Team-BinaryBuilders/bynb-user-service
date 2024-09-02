package com.binarybuilders.bynb_user_service.controller;

<<<<<<< Updated upstream
import com.binarybuilders.bynb_user_service.dto.UserDto;
=======
>>>>>>> Stashed changes
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

    @PostMapping("/register")
    public void saveUser(@RequestBody UserDto user){
        userService.saveUser(user);
    }

    @PostMapping("/login")
    public int Login(@RequestBody UserEntity user) {
        return 1;
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