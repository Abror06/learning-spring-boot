package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.OrderCreateDto;
import com.example.learningspringboot.dto.OrderDto;
import com.example.learningspringboot.model.Order;
import com.example.learningspringboot.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "orderDate", source = "orderDate")
    @Mapping(target = "price", source = "price")
    OrderDto toDto(Order order);

    List<OrderDto> toDto(List<Order> orders);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    @Mapping(target = "price", source = "dto.price")
    @Mapping(target = "orderDate", source = "localDateTime")
    Order toEntity(OrderCreateDto dto, User user, LocalDateTime localDateTime);
}
