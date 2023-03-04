package com.example.userService.controller;

import com.example.userService.dto.User;
import com.example.userService.dto.request.UserCreateRequestDto;
import com.example.userService.dto.response.UserResponseDto;
import com.example.userService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/user-service")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/health_check")
    public String healthCheck(){
        return "It's working";
    }

    @PostMapping
    public UserResponseDto save(@RequestBody UserCreateRequestDto requestDto){
        User user = User.builder()
                .userId(UUID.randomUUID().toString())
                .name(requestDto.getName())
                .identifier(requestDto.getIdentifier())
                .password(requestDto.getPassword())
                .build();
        return UserResponseDto.of(userService.createUser(user));
    }




}
