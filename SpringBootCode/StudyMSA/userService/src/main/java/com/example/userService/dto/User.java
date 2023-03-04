package com.example.userService.dto;

import com.example.userService.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    private String userId;
    private String name;
    private String identifier;
    private String password;

    public static User of(UserEntity userEntity){
        return User.builder()
                .userId(userEntity.getUserId())
                .name(userEntity.getName())
                .identifier(userEntity.getIdentifier())
                .password(userEntity.getPassword())
                .build();
    }
}
