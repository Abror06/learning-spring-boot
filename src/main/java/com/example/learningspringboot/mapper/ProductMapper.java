package com.example.learningspringboot.mapper;


import com.example.learningspringboot.dto.CategoryDto;
import com.example.learningspringboot.dto.ProductCreateDto;
import com.example.learningspringboot.dto.ProductDto;
import com.example.learningspringboot.model.Category;
import com.example.learningspringboot.model.Product;
import com.example.learningspringboot.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final CategoryService categoryService;

    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setProductName(product.getProductName());
        productDto.setQuantity(product.getQuantity());
        productDto.setPricePreOne(product.getPricePreOne());

        Category category = product.getCategory();
        CategoryDto categoryDto = new CategoryDto(category.getCategoryId(), category.getName());

        productDto.setCategory(categoryDto);

        return productDto;
    }

    public List<ProductDto> toDto(List<Product> allProducts) {
        return allProducts.stream().map(this::toDto).toList();
    }

    public Product toEntity(ProductCreateDto dto, Category category) {
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setPricePreOne(dto.getPricePreOne());
        product.setCategory(category);
        product.setQuantity(dto.getQuantity());
        return product;
    }

    public void toUpdateEntity(String productName, Long pricePerOne, Long quantity, Long categoryId, Product product) {
        if (productName != null) {
            product.setProductName(productName);
        }
        product.setPricePreOne(pricePerOne);
        product.setQuantity(quantity);
        Category category = categoryService.findById(categoryId);
        product.setCategory(category);
    }
}
