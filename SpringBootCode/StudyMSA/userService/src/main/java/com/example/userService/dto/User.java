package com.example.userService.dto;

import com.example.userService.dto.response.OrderResponseDto;
import com.example.userService.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    private String userId;
    private String name;
    private String identifier;
    private String password;

    private List<OrderResponseDto> orders;

    public static User of(UserEntity userEntity){
        return User.builder()
                .userId(userEntity.getUserId())
                .name(userEntity.getName())
                .identifier(userEntity.getIdentifier())
                .password(userEntity.getPassword())
                .build();
    }

    public void setOrders(List<OrderResponseDto> orders){
        this.orders = orders;
    }
}
