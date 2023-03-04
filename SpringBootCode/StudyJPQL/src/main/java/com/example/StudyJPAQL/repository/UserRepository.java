package com.example.StudyJPAQL.repository;

import com.example.StudyJPAQL.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE u.name = :name")
    Optional<User> findByNameQuery(@Param("name") String name);

    @Query(value = "SELECT * FROM users as u WHERE u.name = :name", nativeQuery = true)
    Optional<User> findByNameNativeQuery(@Param("name") String name);

}
