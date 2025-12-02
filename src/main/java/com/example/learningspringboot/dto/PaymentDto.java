package com.example.learningspringboot.dto;

import com.example.learningspringboot.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private Long id;

    private Long userId;

    private Long orderId;

    private LocalDateTime date;

    private Long amount;

    private PaymentStatus status;
}
