package com.example.StudyJPAQL.repository;

import com.example.StudyJPAQL.dto.response.PostResponseDto;
import com.example.StudyJPAQL.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT new com.example.StudyJPAQL.dto.response.PostResponseDto(p.id, u.name, p.content) FROM Post p "
            + "LEFT JOIN User u ON p.userId = u.id "
            + "WHERE p.id = :postId"

    )
    PostResponseDto findByPostUser(@Param("postId") Long postId);
}
