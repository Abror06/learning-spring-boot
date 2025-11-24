package com.example.learningspringboot.dto;import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateDto {
    @NotBlank(message = "Product name can not be blank")
    @Size(max = 255)
    private String productName;

    @NotNull
    @Positive
    private Long quantity;

    @NotNull
    @Positive
    private Long pricePreOne;

    @NotNull(message = "Category ID is required")
    @Positive(message = "Category ID must be positive")
    private Long categoryId;
}
