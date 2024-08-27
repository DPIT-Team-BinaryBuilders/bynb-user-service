package com.binarybuilders.bynb_user_service.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@Table(name = "t_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name", unique = true)
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "trust_rating")
    private double trustRating;

    @Column(name = "email_verified")
    private boolean emailVerified;

    @Column(name = "email_token")
    private String emailToken;

    @Column(name = "phone_verified")
    private boolean phoneVerified;

    @Column(name = "phone_token")
    private String phoneToken;

    @Column(name = "verified")
    private boolean verified;

    @ElementCollection
    @CollectionTable(name = "t_user_dangers", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "danger_id")
    private ArrayList<Long> dangers;
}
