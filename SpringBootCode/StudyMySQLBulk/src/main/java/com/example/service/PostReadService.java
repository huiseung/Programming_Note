package com.example.service;

import com.example.dto.Post;
import com.example.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostReadService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<Post> getBetween(Long userId, Instant startDate, Instant endDate){
        return postRepository.findAllByUserIdAndCreateDateBetween(userId, startDate, endDate);
    }

    @Transactional(readOnly = true)
    public Page<Post> getPaging(Long userId, Pageable pageRequest){
        return postRepository.findAllByUserIdPaging(userId, pageRequest);
    }
}
