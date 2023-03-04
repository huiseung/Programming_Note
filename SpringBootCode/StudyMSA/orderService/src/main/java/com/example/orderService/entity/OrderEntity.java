package com.example.orderService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Table(name="orders")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column
    private String orderId;
    @Column
    private Integer quantity;
    @Column
    private Integer unitPrice;

    @Column
    private String productId;
    @Column
    private String userId;

}
