package com.example.repository;

import com.example.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface PostJpaRepository extends JpaRepository<PostEntity, Long> {
    @Query(
            "SELECT p "+
                    "FROM PostEntity p "+
                    "WHERE p.id = :userId and p.createDate between :startDate and :endDate"
    )
    List<PostEntity> findAllByUserIdAndCreateDateBetween(
            @Param("userId") Long userId,
            @Param("startDate")Instant startDate,
            @Param("endDate") Instant endDate
    );

    Page<PostEntity> findAllByUserId(Long userId, Pageable pageable);
}
