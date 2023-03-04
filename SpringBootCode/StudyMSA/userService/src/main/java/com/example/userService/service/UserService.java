package com.example.userService.service;

import com.example.userService.dto.User;
import com.example.userService.dto.request.UserCreateRequestDto;
import com.example.userService.entity.UserEntity;
import com.example.userService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(UserCreateRequestDto requestDto){
        UserEntity userEntity = UserEntity.builder()
                .name(requestDto.getName())
                .identifier(requestDto.getIdentifier())
                .password(requestDto.getPassword())
                .build();
        return userRepository.save(userEntity);
    }
}
