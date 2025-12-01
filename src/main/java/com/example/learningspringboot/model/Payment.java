package com.example.learningspringboot.model;

import com.example.learningspringboot.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "amount")
    private Long amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PaymentStatus status = PaymentStatus.PENDING;
    ;
}
