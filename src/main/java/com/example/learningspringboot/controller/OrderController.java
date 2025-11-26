package com.example.learningspringboot.controller;


import com.example.learningspringboot.dto.OrderCreateDto;
import com.example.learningspringboot.dto.OrderDto;
import com.example.learningspringboot.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAll() {
        List<OrderDto> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable("id") Long id) {
        OrderDto orderById = orderService.findOrderDtoById(id);
        return ResponseEntity.ok(orderById);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody @Valid OrderCreateDto dto) {
        OrderDto orderDto = orderService.createOrder(dto);
        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable(value = "id") Long id) {
        orderService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable(value = "id") Long id, @RequestParam(value = "price", required = false) Long price, @RequestParam(value = "userId", required = false) Long userId) {
        OrderDto orderDto = orderService.updateById(id, price, userId);
        return ResponseEntity.ok(orderDto);
    }
}

