package com.example.learningspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;

    private String productName;

    private Long quantity;

    private Long pricePreOne;

    private CategoryDto category;
}
