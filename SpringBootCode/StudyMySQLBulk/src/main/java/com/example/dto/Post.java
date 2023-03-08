package com.example.dto;

import com.example.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Post {
    private Long id;
    private Long userId;
    private String content;
    private Long likeCount;
    private Instant createAt;

    public static Post of(PostEntity postEntity){
        return Post.builder()
                .id(postEntity.getId())
                .userId(postEntity.getUserId())
                .content(postEntity.getContent())
                .likeCount(postEntity.getLikeCount())
                .createAt(postEntity.getCreateAt())
                .build();
    }
}
