```java
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE u.name = :name")
    Optional<User> findByNameQuery(@Param("name") String name);

    @Query(value = "SELECT * FROM users as u WHERE u.name = :name", nativeQuery = true)
    Optional<User> findByNameNativeQuery(@Param("name") String name);
}
```

# SQL Join

- inner join
  -  FromTable 교집합 JoinTable
```
SELECT *
FROM posts p
JOIN users u
ON p.userId = u.id
```

- left ooter join
  - (FromTable 교집합 JoinTable) 합집합 (FromTable - JoinTable)
  - FromTable쪽에 JoinTable 결합할 키가 없는 경우의 row는 JoinTable column값이 null로 넣어진다
```
SELECT *
FROM posts p
LEFT JOIN users u
ON p.userId = u.id
```


