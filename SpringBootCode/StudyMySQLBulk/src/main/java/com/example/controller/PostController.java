package com.example.controller;

import com.example.dto.Post;
import com.example.dto.request.PostCreateRequestDto;
import com.example.dto.request.PostGetRequestDto;
import com.example.dto.response.PostResponseDto;
import com.example.service.PostReadService;
import com.example.service.PostWriteService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/posts")
@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostWriteService postWriteService;
    private final PostReadService postReadService;

    @PostMapping
    public PostResponseDto save(@RequestBody PostCreateRequestDto requestDto){
        Post post = Post.builder()
                .userId(requestDto.getUserId())
                .content(requestDto.getContent())
                .build();
        return PostResponseDto.of(postWriteService.save(post));
    }

    @GetMapping
    public List<PostResponseDto> getBetween(@RequestBody PostGetRequestDto requestDto){
        return postReadService.getBetween(requestDto.getUserId(), requestDto.getStartDate(), requestDto.getEndDate()).stream()
                .map(PostResponseDto::of)
                .collect(Collectors.toList());
    }

//    @GetMapping("/users/{userId}")
//    public Page<PostResponseDto> getPaging(
//            @PathVariable("userId") Long userId,
//            @RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "size", defaultValue = "10") Integer size
//    ){
//        return postReadService.
//    }

}
