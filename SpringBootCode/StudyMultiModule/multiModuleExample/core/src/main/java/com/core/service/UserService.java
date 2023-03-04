package com.core.service;

import com.core.dto.UserDto;
import com.core.repository.UserRepository;
import com.core.dto.request.CreateUserRequestDto;
import com.core.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserDto save(CreateUserRequestDto requestDto){
        User user = User.builder()
                .name(requestDto.getName())
                .build();
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public UserDto findById(Long id){
        return userRepository.findById(id);
    }
}
