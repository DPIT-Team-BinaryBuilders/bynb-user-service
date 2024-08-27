package com.binarybuilders.bynb_user_service.persistence;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "t_role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}