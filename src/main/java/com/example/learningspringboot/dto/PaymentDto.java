package com.example.learningspringboot.dto;

import com.example.learningspringboot.model.Order;
import com.example.learningspringboot.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private Long id;

    private UserDto user;

    private OrderDto order;

    private LocalDateTime date;

    private Long amount;
}
