package com.example.StudyJPAQL.repository;

import com.example.StudyJPAQL.dto.response.PostResponseDto;
import com.example.StudyJPAQL.entity.Post;
import com.example.StudyJPAQL.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    private String CONTENT = "testContent";
    private String NAME = "testName";
    private Long postId;
    private Long userId;

    @BeforeEach
    public void beforeEach(){
        System.out.println("--- beforeEach Start---");
        User user = User.builder()
                .name(NAME)
                .build();
        userId = userRepository.save(user).getId();

        Post post = Post.builder()
                .content(CONTENT)
                .build();
        post.setUserId(userId);
        postId = postRepository.save(post).getId();
        System.out.println("--- beforeEach End---");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("--- afterEach Start---");
        postRepository.deleteById(postId);
        userRepository.deleteById(userId);
        System.out.println("--- afterEach End---");
    }

    @Test
    public void testFindByPostUserQuery(){
        // when
        PostResponseDto postResponseDto = postRepository.findByPostUser(postId);
        // then
        assertEquals(CONTENT, postResponseDto.getPostContent());
    }
}
