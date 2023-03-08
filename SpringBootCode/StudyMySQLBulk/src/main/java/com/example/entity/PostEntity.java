package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Table(name="posts")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;
    @Column
    private String content;
    @Column
    private Long likeCount;
    @Column
    private Instant createAt;

    @PrePersist
    public void prePersist(){
        this.createAt = Instant.now();
    }

}
