package com.example.StudyJPAQL.repository;

import com.example.StudyJPAQL.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "SELECT u FROM UserEntity u WHERE u.name = :name")
    Optional<UserEntity> findByNameQuery(@Param("name") String name);

    @Query(value = "SELECT * FROM users as u WHERE u.name = :name", nativeQuery = true)
    Optional<UserEntity> findByNameNativeQuery(@Param("name") String name);

}
