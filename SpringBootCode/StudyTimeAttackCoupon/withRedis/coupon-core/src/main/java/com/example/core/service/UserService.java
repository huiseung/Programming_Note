package com.example.core.service;


import com.example.core.dto.User;
import com.example.core.entity.UserEntity;
import com.example.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    @Transactional
    public User save(String name){
        UserEntity user = UserEntity.builder()
                .name(name)
                .build();
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(Long userId){
        return userRepository.findById(userId);
    }

}
