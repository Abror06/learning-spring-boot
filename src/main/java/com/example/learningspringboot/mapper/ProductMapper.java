package com.example.learningspringboot.mapper;


import com.example.learningspringboot.dto.ProductCreateDto;
import com.example.learningspringboot.dto.ProductDto;
import com.example.learningspringboot.model.Category;
import com.example.learningspringboot.model.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface ProductMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "productName", source = "productName")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "pricePerOne", source = "pricePerOne")
    ProductDto toDto(Product product);

    List<ProductDto> toDto(List<Product> allProducts);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", source = "category")
    @Mapping(target = "productName", source = "dto.productName")
    @Mapping(target = "quantity", source = "dto.quantity")
    @Mapping(target = "pricePerOne", source = "dto.pricePerOne")
    Product toEntity(ProductCreateDto dto, Category category);

    @Mapping(target = "productName", source = "productName")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "pricePerOne", source = "pricePerOne")
    void toUpdateEntity(@MappingTarget Product product, String productName, Long pricePerOne, Long quantity, Long categoryId);
}
