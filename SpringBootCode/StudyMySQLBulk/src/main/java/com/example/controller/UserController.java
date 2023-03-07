package com.example.controller;

import com.example.dto.request.UserCreateRequestDto;
import com.example.dto.response.UserResponseDto;
import com.example.service.UserReadService;
import com.example.service.UserWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserWriteService userWriteService;
    private final UserReadService userReadService;

    @PostMapping
    public UserResponseDto saveUser(@RequestBody UserCreateRequestDto requestDto){
        return UserResponseDto.of(userWriteService.save(requestDto));
    }

    @GetMapping("/{userId}")
    public UserResponseDto findUser(@PathVariable("userId") Long userId){
        return UserResponseDto.of(userReadService.findUser(userId));
    }
}
