package com.example.core.service;

import com.example.core.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class QueueService {
    private final RedisRepository redisRepository;

    public Boolean push(String key, Object value, Double score){
        return redisRepository.zAddIfAbsent(key, value, score);
    }

    public Set<Object> peek(String key, long startIndex, long endIndex){
        return redisRepository.zRange(key, startIndex, endIndex);
    }

    public Object pop(String key){
        return redisRepository.zPopMin(key);
    }

    public Long rank(String key, Object value){
        return redisRepository.zRank(key, value);
    }

    public Boolean exist(String key){return redisRepository.exist(key);}
}
