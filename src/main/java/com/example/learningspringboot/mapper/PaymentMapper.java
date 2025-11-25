package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.*;
import com.example.learningspringboot.model.*;

import java.time.LocalDateTime;
import java.util.List;

public interface PaymentMapper {

    PaymentDto toDto(Payment payment);

     List<PaymentDto> toDto(List<Payment> payments);
     void updateEntity(Payment payment, Long amount, User user, Order order);
}
