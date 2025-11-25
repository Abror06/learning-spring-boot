package com.example.learningspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    private Long id;

    private Long orderId;

    private Long productId;

    private Long quantity;
}
