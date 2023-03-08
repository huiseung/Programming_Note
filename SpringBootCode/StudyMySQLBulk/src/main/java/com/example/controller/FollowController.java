package com.example.controller;

import com.example.dto.response.FollowResponseDto;
import com.example.dto.response.UserResponseDto;
import com.example.service.FollowingUserGetService;
import com.example.service.FollowWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/follows")
@RestController
@RequiredArgsConstructor
public class FollowController {
    private final FollowingUserGetService followingUserGetService;
    private final FollowWriteService followWriteService;

    @PostMapping("/{fromId}/{toId}")
    public List<UserResponseDto> follow(
            @PathVariable("fromId") Long fromId,
            @PathVariable("toId") Long toId
    ){
        followWriteService.follow(fromId, toId);
        return followingUserGetService.findUserAllByFromId(fromId).stream()
                .map(UserResponseDto::of)
                .collect(Collectors.toList());
    }

    @GetMapping("/{fromId}")
    public List<UserResponseDto> getFollow(@PathVariable("fromId") Long fromId){
        return followingUserGetService.findUserAllByFromId(fromId).stream()
                .map(UserResponseDto::of)
                .collect(Collectors.toList());
    }


}
