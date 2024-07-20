package com.binarybuilders.bynb_user_service.repository;
import com.binarybuilders.bynb_user_service.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

}
