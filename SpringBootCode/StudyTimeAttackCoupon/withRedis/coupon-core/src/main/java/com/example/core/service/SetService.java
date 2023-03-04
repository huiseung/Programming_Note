package com.example.core.service;

import com.example.core.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SetService {
    private final RedisRepository redisRepository;

    public String getSetKey(String key){
        return key+"_set";
    }

    public Boolean isExist(String key, Object value){
        return redisRepository.sExist(getSetKey(key), value);
    }

    public Long add(String key, Object value){
        return redisRepository.sAdd(getSetKey(key), value);
    }

    public Long size(String key){
        return redisRepository.sSize(getSetKey(key));
    }

    public Boolean exist(String key){return redisRepository.exist(getSetKey(key));}
}
