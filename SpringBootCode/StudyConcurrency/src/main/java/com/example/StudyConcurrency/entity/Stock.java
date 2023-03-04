package com.example.StudyConcurrency.entity;

import lombok.*;

import javax.persistence.*;

@Table(name="stocks")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Long quantity;

    @Version
    private Long version;
    
    public void decrease(Long quantity){
        if(this.quantity - quantity < 0){
            throw new RuntimeException("재고 부족");
        }
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
