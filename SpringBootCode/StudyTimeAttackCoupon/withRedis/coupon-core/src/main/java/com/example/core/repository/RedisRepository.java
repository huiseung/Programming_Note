package com.example.core.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class RedisRepository {
    private final RedisTemplate<String, Object> redisTemplate;

    public Boolean zAddIfAbsent(String key, Object value, Double score){
        return redisTemplate.opsForZSet().addIfAbsent(key, value, score);
    }

    public Object zPopMin(String key){
        Set<ZSetOperations.TypedTuple<Object>> typedTuples = redisTemplate.opsForZSet().popMin(key, 1);
        if(typedTuples == null ){
            return null;
        }
        LinkedList<ZSetOperations.TypedTuple<Object>> typedTupleList = new LinkedList<>(typedTuples);
        if (typedTupleList.size() > 0){
            ZSetOperations.TypedTuple<Object> typedTuple = typedTupleList.get(0);
            return typedTuple.getValue();
        }
        return null;

    }

    public Set<Object> zRange(String key, long start, long end){
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    public Long zRank(String key, Object value){
        return redisTemplate.opsForZSet().rank(key, value);
    }

    public Boolean exist(String key){
        return redisTemplate.hasKey(key);
    }

    public Long sSize(String key){
        return redisTemplate.opsForSet().size(key);
    }

    public Long sAdd(String key, Object value){
        return redisTemplate.opsForSet().add(key, value);
    }

    public Boolean sExist(String key, Object value){
        return redisTemplate.opsForSet().isMember(key, value);
    }


}