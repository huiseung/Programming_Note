package com.example.normal.controller;

import com.example.normal.dto.User;
import com.example.normal.dto.request.UserCreateRequestDto;
import com.example.normal.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/users")
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User saveUser(@RequestBody UserCreateRequestDto requestDto){
        return userService.save(requestDto.getName());
    }


}
