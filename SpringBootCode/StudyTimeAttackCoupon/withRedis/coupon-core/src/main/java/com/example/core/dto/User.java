package com.example.core.dto;

import com.example.core.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    private Long userId;
    private String name;

    public static User of(UserEntity userEntity){
        return User.builder()
                .userId(userEntity.getUserId())
                .name(userEntity.getName())
                .build();
    }

    public UserEntity toEntity(){
        return UserEntity.builder()
                .userId(userId)
                .name(name)
                .build();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
}
