package com.core.repository;

import com.core.dto.UserDto;
import com.core.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final UserJpaRepository userJpaRepository;

    public UserDto save(User user){
        return UserDto.of(userJpaRepository.save(user));
    }

    public UserDto findById(Long id){
        return UserDto.of(userJpaRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }
}
