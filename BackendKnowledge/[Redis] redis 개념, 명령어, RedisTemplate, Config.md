# 클라이언트 접속
- redis-cli
- AUTH [password]

# Redis 특징
- 싱글 스레드
- key-value HashTable 형태로 데이터를 관리하는 데이터베이스
- 다양한 자료구조에 value를 지원한다


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
- key: {(hashKey: value), (hashKey: value), ...} 형태로 값을 저장합니다
- String에 비해 사용하는 메모리를 아낄 수 있습니다
- 2^32-1 개에 hashKey를 담을 수 있습니다