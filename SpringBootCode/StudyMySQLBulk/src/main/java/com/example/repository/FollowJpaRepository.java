package com.example.repository;

import com.example.entity.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowJpaRepository extends JpaRepository<FollowEntity, Long> {
    List<FollowEntity> findAllByFromId(Long fromId);

    List<FollowEntity> findAllByToId(Long toId);

}
