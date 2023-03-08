package com.example.dto;

import com.example.entity.FollowEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Follow {
    private Long id;
    private Long fromId;
    private Long toId;

    public static Follow of(FollowEntity followEntity){
        return Follow.builder()
                .id(followEntity.getId())
                .fromId(followEntity.getFromId())
                .toId(followEntity.getToId())
                .build();
    }

    public FollowEntity toEntity(){
        return FollowEntity.builder()
                .id(id)
                .fromId(fromId)
                .toId(toId)
                .build();
    }
}
