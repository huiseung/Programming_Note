package com.example.repository;

import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    UserEntity save(UserEntity userEntity);
    Optional<UserEntity> findById(Long id);
    @Override
    void deleteById(Long id);
}
