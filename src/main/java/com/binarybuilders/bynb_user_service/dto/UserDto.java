package com.binarybuilders.bynb_user_service.dto;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class UserDto {

    private String username;
    private String password;
    private String email;
    private String phone;

}
