package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.OrderItemCreateDto;
import com.example.learningspringboot.dto.OrderItemDto;
import com.example.learningspringboot.model.OrderItem;
import com.example.learningspringboot.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemDto toDto(OrderItem orderItem);

    List<OrderItemDto> toDto(List<OrderItem> allOrderItems);

    OrderItem toEntity(OrderItemCreateDto orderItemCreateDto);

}
