package com.example.learningspringboot.dto;


import com.example.learningspringboot.enums.PaymentStatus;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentUpdateDto {
    @Positive(message = "User ID must be positive")
    private Long userId;

    @Positive
    private Long amount;

    private PaymentStatus status;
}

