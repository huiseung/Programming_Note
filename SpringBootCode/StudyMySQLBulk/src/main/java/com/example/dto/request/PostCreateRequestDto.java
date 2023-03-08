package com.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter

@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PostCreateRequestDto {
    @NotNull
    private Long userId;
    @NotNull
    private String content;
}
