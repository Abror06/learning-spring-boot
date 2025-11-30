package com.example.learningspringboot.dto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseModifyDto {
    @Positive(message = "Order ID must be positive")
    private Long orderId;

    @Positive(message = "Product ID must be positive")
    private Long prodictId;

    @Positive
    private Long quantity;
}
