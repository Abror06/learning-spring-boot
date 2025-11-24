package com.example.learningspringboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch    = FetchType.LAZY)
    private User user;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "price")
    private Long price;
}
