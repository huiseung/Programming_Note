package com.api.controller;

import com.core.dto.UserDto;
import com.core.dto.request.CreateUserRequestDto;
import com.core.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.core.service.UserService;

@Slf4j
@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDto saveUser(@RequestBody CreateUserRequestDto requestDto){
        log.info("requestDto: "+requestDto);
        return userService.save(requestDto);
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable("userId") Long userId){
        log.info("userId: "+userId);
        return userService.findById(userId);
    }
}
