package com.example.userService.controller;

import com.example.userService.dto.request.UserCreateRequestDto;
import com.example.userService.dto.response.UserResponseDto;
import com.example.userService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        return UserResponseDto.of(userService.createUser(requestDto));
    }




}
