package com.example.learningspringboot.dto;

import com.example.learningspringboot.model.Order;
import com.example.learningspringboot.model.Product;
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
