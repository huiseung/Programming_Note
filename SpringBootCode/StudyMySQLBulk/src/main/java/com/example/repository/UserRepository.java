package com.example.repository;

import com.example.dto.User;
import com.example.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<User> findAllById(List<Long> ids){
        return userJpaRepository.findAllById(ids).stream()
                .map(User::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(Long id){
        userJpaRepository.deleteById(id);
    }
}
