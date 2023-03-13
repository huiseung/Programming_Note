package com.example.StudyJPAQL.repository;

import com.example.StudyJPAQL.entity.PostEntity;
import com.example.StudyJPAQL.entity.UserEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;


import java.time.Instant;
import java.time.Period;
import java.util.List;

@Transactional
@SpringBootTest
public class PostJpaRepositoryTest {
    private static final String NAME = "testName";
    private static final String CONTENT = "how are you?";
    private static final String PREFIX_CONTENT = "how";
    private static final String SUFFIX_CONTENT = "ou?";
    private static final String MIDDLE_CONTENT = "are";


    @Autowired
    private PostJpaRepository postJpaRepository;
    @Autowired
    private UserJpaRepository userJpaRepository;

    private PostEntity postEntity;
    private UserEntity userEntity;


    @BeforeEach
    public  void beforeEach(){
        userEntity = UserEntity.builder()
                .name(NAME)
                .build();
        Long userId = userJpaRepository.save(userEntity).getId();
        postEntity = PostEntity.builder()
                .content(CONTENT)
                .userId(userId)
                .build();
        postJpaRepository.save(postEntity);
    }

    @AfterEach
    public void afterEach(){
        userJpaRepository.deleteAll();
        postJpaRepository.deleteAll();
    }

    @Test
    void testFindByUserName() {
        // when
        List<PostEntity> postEntities1 = postJpaRepository.findByUserNameInnerJoin(NAME);
        List<PostEntity> postEntities2 = postJpaRepository.findByUserNameLeftOuterJoin(NAME);
        // then
        System.out.println(postEntities1);
        System.out.println(postEntities2);
    }
    @Test
    void testFindContent() {
        // when
        List<PostEntity> postEntities1 = postJpaRepository.findByContentLike(MIDDLE_CONTENT);
        List<PostEntity> postEntities2 = postJpaRepository.findByContentLike(CONTENT);
        List<PostEntity> postEntities3 = postJpaRepository.findByContentStartWith(PREFIX_CONTENT);
        List<PostEntity> postEntities4 = postJpaRepository.findByContentEndWith(SUFFIX_CONTENT);
        List<PostEntity> postEntities5 = postJpaRepository.findByContentNotLike(CONTENT);
        // then
        System.out.println(postEntities1);
        System.out.println(postEntities2);
        System.out.println(postEntities3);
        System.out.println(postEntities4);
        System.out.println(postEntities5);
    }

    @Test
    void testFindBetween() {
        Page<PostEntity> postEntities = postJpaRepository.findBetween(Instant.now().min)
    }
}
