package com.example.learningspringboot.service;

import com.example.learningspringboot.dto.OrderItemCreateDto;
import com.example.learningspringboot.dto.OrderItemDto;
import com.example.learningspringboot.exception.IllegalQuantityException;
import com.example.learningspringboot.exception.OrderItemNotFoundException;
import com.example.learningspringboot.mapper.OrderItemMapper;
import com.example.learningspringboot.model.Order;
import com.example.learningspringboot.model.OrderItem;
import com.example.learningspringboot.model.Product;
import com.example.learningspringboot.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderItemMapper orderItemMapper;

    public List<OrderItemDto> findAll() {
        List<OrderItem> allOrderItems = orderItemRepository.findAll();
        return orderItemMapper.toDto(allOrderItems);
    }

    public OrderItem findById(Long id) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(id);
        if (optionalOrderItem.isPresent()) {
            return optionalOrderItem.get();
        }
        throw new OrderItemNotFoundException("Ordered item by id: " + id + " not found:");
    }

    public OrderItemDto findOrderItemDtoById(Long id) {
        return orderItemMapper.toDto(findById(id));
    }

    public OrderItemDto createOrderItem(OrderItemCreateDto dto) {
        OrderItem orderItem = new OrderItem();

        persist(orderItem, dto.getOrderId(), dto.getProdictId(), dto.getQuantity());
        return orderItemMapper.toDto(orderItem);
    }

    public OrderItemDto updateOrderItem(Long orderItemId, Long orderId, Long productId, Long quantity) {
        OrderItem orderItem = findById(orderItemId);

        return orderItemMapper.toDto(persist(orderItem, orderId, productId, quantity));
    }

    public void deleteById(Long id) {
        OrderItem orderItem = findById(id);

        orderItemRepository.delete(orderItem);
    }

    private void checkQuantity(Long quantity) {
        if (quantity == null) return;
        if (quantity < 1) {
            throw new IllegalQuantityException("Quantity must be more than 0 ");
        }
    }

    private OrderItem persist(OrderItem orderItem, Long orderId, Long productId, Long quantity) {
        checkQuantity(quantity);

        Product product = null;
        Order order = null;
        if (productId != null || orderId != null) {
            product = productService.findById(productId);
            order = orderService.findById(orderId);
        }

        orderItemMapper.toUpdateEntity(orderItem, quantity, order, product);

        return orderItemRepository.save(orderItem);
    }
}
