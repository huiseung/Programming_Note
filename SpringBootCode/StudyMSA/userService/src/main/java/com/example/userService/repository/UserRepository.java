package com.example.userService.repository;

import com.example.userService.dto.User;
import com.example.userService.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final UserJpaRepository userJpaRepository;

    @Transactional
    public User save(UserEntity userEntity){
        return User.of(userJpaRepository.save(userEntity));
    }

    @Transactional


}
