package com.example.userService.dto.response;

import com.example.userService.dto.User;
import lombok.*;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserResponseDto {
    private String userId;
    private String name;
    private String identifier;
    private List<OrderResponseDto> orders;


    public static UserResponseDto of(User user){
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .identifier(user.getIdentifier())
                .orders(user.getOrders())
                .build();
    }

}
