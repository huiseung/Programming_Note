package com.example.service;

import com.example.dto.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserReadService {
    private final UserRepository userRepository;

    @Transactional
    public User findUser(Long id){
        return userRepository.findById(id);
    }


}
