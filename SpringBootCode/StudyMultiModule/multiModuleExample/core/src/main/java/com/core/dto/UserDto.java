package com.core.dto;

import com.core.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;

    public static UserDto of(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
