package com.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PostGetRequestDto {
    private Long userId;
    private Instant startDate;
    private Instant endDate;
}
