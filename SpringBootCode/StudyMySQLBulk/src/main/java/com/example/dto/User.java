package com.example.dto;

import com.example.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    private Long id;
    private String nickname;
    private Instant createDate;

    public void changeNickName(String nickname){
        this.nickname = nickname;
    }

    public static User of(UserEntity userEntity){
        return User.builder()
                .id(userEntity.getId())
                .nickname(userEntity.getNickname())
                .createDate(userEntity.getCreateDate())
                .build();
    }

    public UserEntity toEntity(){
        return UserEntity.builder()
                .id(id)
                .nickname(nickname)
                .createDate(createDate)
                .build();
    }
}
