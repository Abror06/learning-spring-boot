package com.example.learningspringboot.service;

import com.example.learningspringboot.dto.OrderCreateDto;
import com.example.learningspringboot.dto.OrderDto;
import com.example.learningspringboot.exception.OrderNotFoundExeption;
import com.example.learningspringboot.mapper.OrderMapper;
import com.example.learningspringboot.model.Order;
import com.example.learningspringboot.model.User;
import com.example.learningspringboot.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final OrderMapper orderMapper;

    public List<OrderDto> findAll() {
        List<Order> allOrders = orderRepository.findAll();
        return orderMapper.toDto(allOrders);
    }

    public Order findById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            return optionalOrder.get();
        }
        throw new OrderNotFoundExeption("Order not found");
    }

    public OrderDto findOrderDtoById(Long id) {
        return orderMapper.toDto(findById(id));
    }

    public OrderDto createOrder(OrderCreateDto dto) {

        User user = userService.findById(dto.getUserId());
        Order order = orderMapper.toEntity(dto, user);

         orderRepository.save(order);
         return orderMapper.toDto(order);
    }


    public void deleteById(Long id) {
        Order order = findById(id);

        orderRepository.delete(order);
    }

    public Order updateById(Long orderId, Long price) {
        Order order = findById(orderId);
        order.setPrice(price);
        return order;
    }


    private List<Order> getOrdersByUserId(Long userId) {
        User user = userService.findById(userId);
        return orderRepository.findByUser(user);
    }
}
