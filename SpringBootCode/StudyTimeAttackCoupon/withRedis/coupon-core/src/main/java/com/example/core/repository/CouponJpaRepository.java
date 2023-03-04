package com.example.core.repository;


import com.example.core.entity.CouponEntity;
import com.example.core.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CouponJpaRepository extends JpaRepository<CouponEntity,Long> {

    @Query(value = "select c from CouponEntity c where c.user = :userEntity")
    Optional<CouponEntity> findByUserEntity(@Param("userEntity") UserEntity userEntity);
}
