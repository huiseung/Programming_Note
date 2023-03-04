package com.example.noKafka.adapter.product.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="products")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductEntity {
    @Column(name = "product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private Integer price;
    @Column
    private Integer stockAmount;
}
