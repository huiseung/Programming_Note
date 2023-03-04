package com.example.userService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String identifier;
    @NotNull
    private String password;

}
