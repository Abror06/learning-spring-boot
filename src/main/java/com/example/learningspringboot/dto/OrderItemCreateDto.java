package com.example.learningspringboot.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemCreateDto {
    

    @NotNull(message = "Order ID is required")
    @Positive(message = "Order ID must be positive")
    private Long orderId;

    @NotNull(message = "Product ID is required")
    @Positive(message = "Product ID must be positive")
    private Long prodictId;

    @NotNull
    @Positive
    private Long quantity;

}
