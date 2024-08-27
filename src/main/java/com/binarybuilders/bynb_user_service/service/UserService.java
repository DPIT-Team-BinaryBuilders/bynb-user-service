package com.binarybuilders.bynb_user_service.service;


import com.binarybuilders.bynb_user_service.dto.UserDto;
import com.binarybuilders.bynb_user_service.exception.EmailExistsException;
import com.binarybuilders.bynb_user_service.messaging.UserServiceSender;
import com.binarybuilders.bynb_user_service.persistence.UserEntity;
import com.binarybuilders.bynb_user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UserDto user) throws EmailExistsException {
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new EmailExistsException("Email already exists");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setPasswordHash(passwordEncoder.encode(user.getPassword()));
        userEntity.setPhoneNumber(user.getPhone());
        System.out.println(userEntity.getEmail());
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