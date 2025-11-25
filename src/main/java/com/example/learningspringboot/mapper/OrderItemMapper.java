package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.OrderItemDto;
import com.example.learningspringboot.model.Order;
import com.example.learningspringboot.model.OrderItem;
import com.example.learningspringboot.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderItemMapper {
    public OrderItemDto toDto(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setId(orderItem.getId());
        orderItemDto.setOrderId(orderItem.getOrder().getId());
        orderItemDto.setProductId(orderItem.getProduct().getId());
        orderItemDto.setQuantity(orderItem.getQuantity());
        return orderItemDto;
    }

    public List<OrderItemDto> toDto(List<OrderItem> orderItems) {
        return orderItems.stream().map(this::toDto).toList();
    }

    public void updateEntity(OrderItem orderItem, Long quantity, Order order, Product product) {
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
    }
}
