package com.example.repository;

import com.example.dto.User;
import com.example.entity.UserEntity;
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
    public User findById(Long id){
        return User.of(userJpaRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Transactional
    public void deleteById(Long id){
        userJpaRepository.deleteById(id);
    }
}
