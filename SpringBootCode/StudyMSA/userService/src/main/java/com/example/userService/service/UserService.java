package com.example.userService.service;

import com.example.userService.dto.User;
import com.example.userService.dto.request.UserCreateRequestDto;
import com.example.userService.entity.UserEntity;
import com.example.userService.fieignClient.OrderServiceClient;
import com.example.userService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final OrderServiceClient orderServiceClient;

    @Transactional
    public User createUser(User user){
        UserEntity userEntity = UserEntity.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .identifier(user.getIdentifier())
                .password(user.getPassword())
                .build();
        return userRepository.save(userEntity);
    }

    @Transactional
    public User getUserById(String userId){
        User user = userRepository.findByUserId(userId);
        user.setOrders(orderServiceClient.getOrders(userId));
        return user;
    }


}
