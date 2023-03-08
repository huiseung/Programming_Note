package com.example.service;

import com.example.dto.Follow;
import com.example.dto.User;
import com.example.repository.FollowRepository;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FollowingUserGetService {
    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<User> findUserAllByFromId(Long fromId) {
        List<Long> toIds =  followRepository.findAllByFromId(fromId).stream()
                .map(Follow::getToId)
                .collect(Collectors.toList());
        return userRepository.findAllById(toIds);
    }
}