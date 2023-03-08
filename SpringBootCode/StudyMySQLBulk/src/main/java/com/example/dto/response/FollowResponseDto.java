package com.example.dto.response;

import com.example.dto.Follow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class FollowResponseDto {
    private Long id;
    private Long fromId;
    private Long toId;

    public static FollowResponseDto of(Follow follow){
        return FollowResponseDto.builder()
                .id(follow.getId())
                .fromId(follow.getFromId())
                .toId(follow.getToId())
                .build();
    }
}
