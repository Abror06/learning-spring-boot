package com.example.learningspringboot.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDto {
    @NotNull(message = "User ID is required")
    @Positive(message = "User ID must be positive")
    private Long userId;


    @NotNull
    @Positive
    private Long price;
}
