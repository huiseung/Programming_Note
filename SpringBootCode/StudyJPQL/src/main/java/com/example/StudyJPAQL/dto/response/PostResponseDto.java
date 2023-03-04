package com.example.StudyJPAQL.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private Long postId;
    private String userName;
    private String postContent;

    public PostResponseDto(Long postId, String userName, String postContent) {
        this.postId = postId;
        this.userName = userName;
        this.postContent = postContent;
    }
}
