package com.example.learningspringboot.mapper;
;
import com.example.learningspringboot.dto.OrderCreateDto;
import com.example.learningspringboot.dto.OrderDto;
import com.example.learningspringboot.model.Order;
import com.example.learningspringboot.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    public OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();

        orderDto.setId(order.getId());
        orderDto.setUserId(order.getUser().getId());
        orderDto.setOrderDate(order.getOrderDate());
        orderDto.setPrice(order.getPrice());

        return orderDto;
    }

    public List<OrderDto> toDto(List<Order> orders) {
        return orders.stream().map(this::toDto).toList();
    }

    public Order toEntity(OrderCreateDto dto, User user) {
        Order order = new Order();

        order.setUser(user);
        order.setPrice(dto.getPrice());
        order.setOrderDate(LocalDateTime.now());

        return order;
    }
}
