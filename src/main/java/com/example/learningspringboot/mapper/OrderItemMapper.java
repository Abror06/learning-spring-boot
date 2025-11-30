package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.OrderItemDto;
import com.example.learningspringboot.model.Order;
import com.example.learningspringboot.model.OrderItem;
import com.example.learningspringboot.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.MappingTarget;


import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface OrderItemMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "orderId", source = "order.id")
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "quantity", source = "quantity")
    OrderItemDto toDto(OrderItem orderItem);

    List<OrderItemDto> toDto(List<OrderItem> orderItems);

    @Mapping(target = "order", source = "order")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "id", ignore = true)
    void toUpdateEntity(@MappingTarget OrderItem orderItem, Long quantity, Order order, Product product);
}
