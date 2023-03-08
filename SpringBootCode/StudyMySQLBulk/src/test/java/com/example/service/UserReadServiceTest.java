package com.example.service;

import com.example.dto.User;
import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
public class UserReadServiceTest {
    private static final String NICKNAME = "testName";
    @Autowired
    private UserReadService userReadService;
    @Autowired
    private UserRepository userRepository;

    private Long id;

    @BeforeEach
    public void beforeEach(){
        UserEntity userEntity = UserEntity.builder()
                .nickname(NICKNAME)
                .build();
        id = userRepository.save(userEntity).getId();
    }

    @AfterEach
    public void afterEach(){
        userRepository.deleteById(id);
    }

    @DisplayName("test find User")
    @Test
    public void testFindUser(){
        // when
        User user = userReadService.findUser(id);
        // then
        assertEquals(NICKNAME, user.getNickname());
    }
}
