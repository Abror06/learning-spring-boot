package com.example.learningspringboot.mapper;


import com.example.learningspringboot.dto.ProductCreateDto;
import com.example.learningspringboot.dto.ProductDto;
import com.example.learningspringboot.model.Category;
import com.example.learningspringboot.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);

    List<ProductDto> toDto(List<Product> allProducts);

    Product toEntity(ProductCreateDto dto, Category category);

    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "pricePreOne", target = "pricePreOne")
    void toUpdateEntity(String productName, Long pricePerOne, Long quantity, Long categoryId, Product product);
}
