package com.example.learningspringboot.service;

import com.example.learningspringboot.dto.OrderCreateDto;
import com.example.learningspringboot.dto.OrderDto;
import com.example.learningspringboot.exception.OrderNotFoundException;
import com.example.learningspringboot.mapper.OrderMapper;
import com.example.learningspringboot.model.Order;
import com.example.learningspringboot.model.User;
import com.example.learningspringboot.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final OrderMapper orderMapper;

    public Page<OrderDto> findAll(Pageable pageable) {
        Page<Order> allOrders = orderRepository.findAll(pageable);

        Page<OrderDto> dtoPage = allOrders.map(orderMapper::toDto);
        return dtoPage;
    }

    public Order findById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            return optionalOrder.get();
        }
        throw new OrderNotFoundException("Order not found");
    }

    public OrderDto findOrderDtoById(Long id) {
        return orderMapper.toDto(findById(id));
    }

    public OrderDto createOrder(OrderCreateDto dto) {

        User user = userService.findById(dto.getUserId());
        Order order = orderMapper.toEntity(dto, user, LocalDateTime.now());

        orderRepository.save(order);
        return orderMapper.toDto(order);
    }


    public void deleteById(Long id) {
        Order order = findById(id);

        orderRepository.delete(order);
    }

    public OrderDto updateById(Long orderId, Long price, Long userId) {
        Order order = findById(orderId);

        User user = null;
        if (userId != null) {
            user = userService.findById(userId);
        }
        orderMapper.toUpdateEntity(order, price, user);
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }


    private List<Order> getOrdersByUserId(Long userId) {
        User user = userService.findById(userId);
        return orderRepository.findByUser(user);
    }
}
