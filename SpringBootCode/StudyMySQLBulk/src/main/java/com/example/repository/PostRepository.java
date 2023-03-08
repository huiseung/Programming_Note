package com.example.repository;

import com.example.dto.Post;
import com.example.entity.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final PostJpaRepository postJpaRepository;

    @Transactional
    public Post save(PostEntity postEntity){
        return Post.of(postJpaRepository.save(postEntity));
    }

    @Transactional(readOnly = true)
    public List<Post> findAllByUserIdAndCreateDateBetween(Long userId, Instant startDate, Instant endDate){
        return postJpaRepository.findAllByUserIdAndCreateDateBetween(userId, startDate, endDate).stream()
                .map(Post::of)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<Post> findAllByUserIdPaging(Long userId, Pageable pageable){
        return postJpaRepository.findAllByUserId(userId, pageable).map(Post::of);
    }
}
