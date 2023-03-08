package com.example.dto.response;

import com.example.dto.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String nickname;
    private Instant createAt;

    public static UserResponseDto of(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .createAt(user.getCreateAt())
                .build();
    }

}
