package com.example.StudyJPAQL.repository;

import com.example.StudyJPAQL.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface PostJpaRepository extends JpaRepository<PostEntity, Long> {
    PostEntity save(PostEntity postEntity);

    Optional<PostEntity> findById(Long id);

    void deleteAll();

    // like content
    @Query("SELECT p " +
            "FROM PostEntity p " +
            "WHERE p.content LIKE %:content%")
    List<PostEntity> findByContentLike(@Param("content") String content);

    @Query("SELECT p " +
            "FROM PostEntity p " +
            "WHERE p.content LIKE :content%")
    List<PostEntity> findByContentStartWith(@Param("content") String content);

    @Query("SELECT p " +
            "FROM PostEntity p " +
            "WHERE p.content LIKE %:content")
    List<PostEntity> findByContentEndWith(@Param("content") String content);

    @Query("SELECT p " +
            "FROM PostEntity p " +
            "WHERE p.content NOT LIKE %:content")
    List<PostEntity> findByContentNotLike(@Param("content") String content);

    // join
    @Query("SELECT p " +
            "FROM PostEntity p " +
            "INNER JOIN UserEntity u " +
            "ON p.userId = u.id "+
            "WHERE u.name = :name "
    )
    List<PostEntity> findByUserNameInnerJoin(@Param("name") String name);

    @Query("SELECT p " +
            "FROM PostEntity p " +
            "LEFT JOIN UserEntity u " +
            "ON p.userId = u.id "+
            "WHERE u.name = :name "
    )
    List<PostEntity> findByUserNameLeftOuterJoin(@Param("name") String name);

    @Query("SELECT p "+
    "FROM PostEntity p "+
    "WHERE p.createdDate >= :startDate AND p.createdDate <= :endDate")
    Page<PostEntity> findBetween(@Param("startDate")Instant startDate, @Param("endDate") Instant endDate);
}
