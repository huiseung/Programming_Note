package com.example.normal.repository;

import com.example.normal.dto.User;
import com.example.normal.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final UserJpaRepository userJpaRepository;


    @Transactional(readOnly = true)
    public User findById(Long userId){
        return User.of(userJpaRepository.findById(userId)
                .orElseThrow(IllegalAccessError::new)
        );
    }

    @Transactional
    public User save(UserEntity userEntity){
        return User.of(userJpaRepository.save(userEntity));
    }



}
