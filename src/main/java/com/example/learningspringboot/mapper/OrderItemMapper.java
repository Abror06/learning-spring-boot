package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.OrderItemCreateDto;
import com.example.learningspringboot.dto.OrderItemDto;
import com.example.learningspringboot.model.OrderItem;


import java.util.List;

public interface OrderItemMapper {
    OrderItemDto toDto(OrderItem orderItem);



    List<OrderItemDto> toDto(List<OrderItem> allOrderItems);


}
