package com.example.StudyJPAQL.repository;

import com.example.StudyJPAQL.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private String NAME ="testName";
    private Long userId;

    @BeforeEach
    public void beforeEach(){
        User user = User.builder()
                .name(NAME)
                .build();
        userId = userRepository.save(user).getId();
    }

    @AfterEach
    public void afterEach(){
        userRepository.deleteById(userId);
    }

    @Test
    public void testQueryFindByName(){
        // when
        User user = userRepository.findByNameQuery(NAME).orElseThrow(IllegalArgumentException::new);
        // then
        assertEquals(NAME, user.getName());
    }

    @Test
    public void testFindByNameNativeQuery(){
        // when
        User user = userRepository.findByNameNativeQuery(NAME).orElseThrow(IllegalArgumentException::new);
        // then
        assertEquals(NAME, user.getName());
    }
}
