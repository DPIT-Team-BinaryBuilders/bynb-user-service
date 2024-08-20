package com.binarybuilders.bynb_user_service.service;


import com.binarybuilders.bynb_user_service.dto.UserDto;
import com.binarybuilders.bynb_user_service.messaging.UserServiceSender;
import com.binarybuilders.bynb_user_service.persistence.UserEntity;
import com.binarybuilders.bynb_user_service.repository.UserRepository;
import com.binarybuilders.bynb_user_service.util.PasswordEncoder;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserServiceSender userServiceSender){
        this.userRepository = userRepository;
    }

    public void saveUser(UserDto user){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setPasswordHash(new BCryptPasswordEncoder().encode(user.getPassword()));
        userEntity.setPhoneNumber(user.getPhone());
        userRepository.save(userEntity);
    }


    public UserEntity getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }


    public Optional<UserEntity> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity updateUser(UserEntity user){
        return userRepository.save(user);
    }
}