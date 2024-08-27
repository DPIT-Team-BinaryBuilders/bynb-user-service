package com.binarybuilders.bynb_user_service.repository;


import com.binarybuilders.bynb_user_service.persistence.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
}