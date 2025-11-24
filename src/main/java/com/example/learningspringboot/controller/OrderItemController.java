package com.example.learningspringboot.controller;

import com.example.learningspringboot.dto.OrderItemCreateDto;
import com.example.learningspringboot.dto.OrderItemDto;
import com.example.learningspringboot.model.OrderItem;
import com.example.learningspringboot.service.OrderItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/orderItem")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItemDto>> getAll() {
        List<OrderItemDto> allUsers = orderItemService.findAll();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDto> getById(@PathVariable("id") Long id) {
        OrderItemDto orderItemId = orderItemService.findOrderItemDtoById(id);
        return ResponseEntity.ok(orderItemId);
    }

    @PostMapping
    public ResponseEntity<OrderItemDto> createOrderItem(@RequestBody @Valid OrderItemCreateDto dto) {
        OrderItemDto orderItem = orderItemService.createOrderItem(dto);
        return new ResponseEntity<>(orderItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable(value = "id") Long id, @RequestParam(value = "orderId", required = false) Long orderId, @RequestParam(value = "productId", required = false) Long productId, @RequestParam(value = "quantity", required = false) Long quantity) {
        OrderItem orderItem = orderItemService.updateOrderItem(id, orderId, productId, quantity);
        return ResponseEntity.ok(orderItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable(value = "id") Long id) {
        orderItemService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
