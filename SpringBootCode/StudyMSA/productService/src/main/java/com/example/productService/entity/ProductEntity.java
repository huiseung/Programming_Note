package com.example.productService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Table(name="products")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column
    private String productId;
    @Column
    private String productName;
    @Column
    private Integer stock;
    @Column
    private Integer price;

}
