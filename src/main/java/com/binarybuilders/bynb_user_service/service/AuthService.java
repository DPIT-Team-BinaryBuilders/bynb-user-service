package com.binarybuilders.bynb_user_service.service;

import com.binarybuilders.bynb_user_service.dto.AuthResponseDto;
import com.binarybuilders.bynb_user_service.dto.LoginDto;
import com.binarybuilders.bynb_user_service.dto.UserDto;
import com.binarybuilders.bynb_user_service.persistence.Role;
import com.binarybuilders.bynb_user_service.persistence.UserEntity;
import com.binarybuilders.bynb_user_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.AuthProvider;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;

@Service

public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    public AuthResponseDto register(UserDto request){
        var user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        user.setEmail(request.getEmail());
        userRepository.save(user);
        String token = jwtService.generateToken(user, generateExtraClaims(user));
        return  new AuthResponseDto(token);
    }




    public AuthResponseDto login(LoginDto authenticationRequest){
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()
        );
        Authentication authentication = authenticationManager.authenticate(authToken);
            UserEntity user = userRepository.findByUsername(authenticationRequest.getUsername()).get();
            String jwt = jwtService.generateToken(user, generateExtraClaims(user));
            return new AuthResponseDto(jwt);

    }

    private Map<String, Object> generateExtraClaims(UserEntity user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getUsername());
        extraClaims.put("authorities", user.getAuthorities());
        return extraClaims;
    }
}

