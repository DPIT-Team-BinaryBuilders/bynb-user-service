package com.binarybuilders.bynb_user_service.service;


<<<<<<< Updated upstream
import com.binarybuilders.bynb_user_service.dto.UserDto;
import com.binarybuilders.bynb_user_service.exception.EmailExistsException;
import com.binarybuilders.bynb_user_service.messaging.UserServiceSender;
import com.binarybuilders.bynb_user_service.persistence.UserEntity;
import com.binarybuilders.bynb_user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
=======
import com.binarybuilders.bynb_user_service.persistence.UserEntity;
import com.binarybuilders.bynb_user_service.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
>>>>>>> Stashed changes
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
<<<<<<< Updated upstream
    private final PasswordEncoder passwordEncoder;
=======
>>>>>>> Stashed changes



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }



    public UserEntity getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public String getUserIdByUsername(String username){
        return userRepository.findByUsername(username).get().getId().toString();
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