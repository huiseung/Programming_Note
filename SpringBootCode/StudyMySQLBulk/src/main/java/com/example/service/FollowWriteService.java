package com.example.service;

import com.example.dto.Follow;
import com.example.entity.FollowEntity;
import com.example.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FollowWriteService {
    private final FollowRepository followRepository;

    @Transactional
    public Follow follow(Long fromId, Long toId){
        if(fromId.equals(toId)){
            throw new IllegalArgumentException("from 과 to user 는 달라야 합니다");
        }
        FollowEntity followEntity = FollowEntity.builder()
                .fromId(fromId)
                .toId(toId)
                .build();
        return followRepository.save(followEntity);
    }
}
