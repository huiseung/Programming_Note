package com.example.service;

import com.example.dto.User;
import com.example.dto.request.UserCreateRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
public class UserWriteServiceTest {
    private static final String NICKNAME = "testName";
    @Autowired
    private UserWriteService userWriteService;

    @DisplayName("test save user")
    @Test
    public void testWriteUser(){
        UserCreateRequestDto requestDto = new UserCreateRequestDto(NICKNAME);
        // when
        User user = userWriteService.save(requestDto);
        // then
        assertEquals(NICKNAME, user.getNickname());
    }
}
