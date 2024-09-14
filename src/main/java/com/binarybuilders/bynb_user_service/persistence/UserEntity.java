package com.binarybuilders.bynb_user_service.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Getter
@Setter
@Table(name = "t_user")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

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


//    @ElementCollection
//    @CollectionTable(name = "t_user_dangers", joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "danger_id")
//    private ArrayList<Long> dangers;

    @Enumerated(EnumType.STRING)
    private Role role;

//    @ElementCollection
//    @CollectionTable(name = "t_user_dangers", joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "danger_id")
//    private ArrayList<Long> dangers;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = role.getPermissions().stream().map(
                permissionEnum -> new SimpleGrantedAuthority(permissionEnum.name())
        ).collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));


        return authorities;
    }

}
