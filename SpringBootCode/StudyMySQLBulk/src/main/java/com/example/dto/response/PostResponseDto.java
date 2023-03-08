package com.example.dto.response;

import com.example.dto.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PostResponseDto {
    private Long id;
    private String content;
    private Instant createDate;

    public static PostResponseDto of(Post post){
        return PostResponseDto.builder()
                .id(post.getId())
                .content(post.getContent())
                .createDate(post.getCreateDate())
                .build();
    }
}
