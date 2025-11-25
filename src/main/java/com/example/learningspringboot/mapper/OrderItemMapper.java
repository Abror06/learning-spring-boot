package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.OrderItemDto;
import com.example.learningspringboot.model.Order;
import com.example.learningspringboot.model.OrderItem;
import com.example.learningspringboot.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemDto toDto(OrderItem orderItem);

    List<OrderItemDto> toDto(List<OrderItem> orderItems);

    //orderId ga qanday berishni bilmadim orderdan idsini olib
    @Mapping(target = "order", source = "orderId")
    @Mapping(target = "product.getId()", source = "productId")
    @Mapping(target = "quantity", source = "quantity")
    void updateEntity(OrderItem orderItem, Long quantity, Order order, Product product);
}
