package com.example.userService.service;

import com.example.userService.client.OrderServiceClient;
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
    private final OrderServiceClient orderServiceClient;

    public User createUser(User user){
        UserEntity userEntity = UserEntity.builder()
                .name(user.getName())
                .identifier(user.getIdentifier())
                .password(user.getPassword())
                .build();
        return userRepository.save(userEntity);
    }

    public User getUserByUserId(String userId){
        User user = userRepository
    }
}
