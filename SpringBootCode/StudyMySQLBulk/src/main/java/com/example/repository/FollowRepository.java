package com.example.repository;

import com.example.dto.Follow;
import com.example.entity.FollowEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class FollowRepository {
    private final FollowJpaRepository followJpaRepository;

    @Transactional
    public Follow save(FollowEntity followEntity){
        return Follow.of(followJpaRepository.save(followEntity));
    }

    @Transactional
    public List<Follow> findAllByFromId(Long fromId){
        return followJpaRepository.findAllByFromId(fromId).stream()
                .map(Follow::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Follow> findAllByToId(Long toId){
        return followJpaRepository.findAllByToId(toId).stream()
                .map(Follow::of)
                .collect(Collectors.toList());
    }


}
