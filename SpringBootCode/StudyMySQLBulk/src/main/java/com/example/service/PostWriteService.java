package com.example.service;

import com.example.dto.Post;
import com.example.entity.PostEntity;
import com.example.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostWriteService {
    private final PostRepository postRepository;

    @Transactional
    public Post save(Post post){
        return postRepository.save(post.toEntity());
    }
}
