package com.example.userService.dto.response;

import com.example.userService.dto.User;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserResponseDto {
    private String userId;
    private String name;
    private String identifier;

    public static UserResponseDto of(User user){
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .identifier(user.getIdentifier())
                .build();
    }

}
