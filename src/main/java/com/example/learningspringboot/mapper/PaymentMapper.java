package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.*;
import com.example.learningspringboot.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentMapper {
    private final UserMapper userMapper;
    private final OrderMapper orderMapper;

    public PaymentDto toDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setId(payment.getId());
        paymentDto.setUser(userMapper.toDto(payment.getUser()));
        paymentDto.setOrder(orderMapper.toDto(payment.getOrder()));
        paymentDto.setDate(payment.getDate());
        paymentDto.setAmount(payment.getAmount());

        return paymentDto;
    }

    public List<PaymentDto> toDto(List<Payment> payments) {
        return payments.stream().map(this::toDto).toList();
    }

    public void updateEntity(Payment payment, Long amount, User user, Order order) {

        payment.setUser(user);
        payment.setOrder(order);
        payment.setDate(LocalDateTime.now());
        payment.setAmount(amount);
    }
}
