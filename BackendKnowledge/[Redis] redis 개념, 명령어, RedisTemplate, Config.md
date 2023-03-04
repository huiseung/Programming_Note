# 클라이언트 접속
- redis-cli
- AUTH [password]

# Redis Server 
- 싱글 스레드


# 자료구조
- exists key
  - key라는 자료구조가 존재하는지 확인
    - 있으면 1, 없으면 0

## SortedSet(ZSet)
- zadd key score value
  - key라는 SortedSet에 value라는 값을 score기준 오름차순으로 저장
  - 성공시 1, 실패시 0 반환
- zadd nx key score value
  - redisTemplate에선 zaddifabsent key score value
  - key라는 SortedSet에 value라는 값이 기존에 없다면 score기준 오름차순 저장
  - 성공시 1, 실패시 0 반환
- zscore key value
  - key라는 SortedSet에 value에 score를 반환
- zrank key value
  - key라는 SortedSet에 value에 score 순위를 반환

## Set
- sadd key value
  - key라는 Set에 value 추가
- scard key
  - key라는 Set에 value 갯수 반환



## Strings


## List


## HashTable