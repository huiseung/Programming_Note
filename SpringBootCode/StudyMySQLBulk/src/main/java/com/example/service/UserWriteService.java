package com.example.service;

import com.example.dto.User;
import com.example.dto.request.UserCreateRequestDto;
import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserWriteService {
    private final UserRepository userRepository;

    @Transactional
    public User save(UserCreateRequestDto requestDto){
        UserEntity userEntity = UserEntity.builder()
                .nickname(requestDto.getNickname())
                .userId(UUID.randomUUID().toString())
                .build();
        return userRepository.save(userEntity);
    }

    @Transactional
    public User changeNickname(Long id, String nickname){
        User user = userRepository.findById(id);
        user.changeNickName(nickname);
        return userRepository.save(user.toEntity());
    }

    @Transactional
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
