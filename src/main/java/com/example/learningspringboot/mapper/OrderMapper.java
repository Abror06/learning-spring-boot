package com.example.learningspringboot.mapper;
;
import com.example.learningspringboot.dto.OrderCreateDto;
import com.example.learningspringboot.dto.OrderDto;
import com.example.learningspringboot.model.Order;
import com.example.learningspringboot.model.User;
import org.mapstruct.Mapper;


import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

     OrderDto toDto(Order order);

     List<OrderDto> toDto(List<Order> orders);

     Order toEntity(OrderCreateDto dto, User user);
}
