package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.*;
import com.example.learningspringboot.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "order", source = "order")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "amount", source = "amount")
    PaymentDto toDto(Payment payment);

    List<PaymentDto> toDto(List<Payment> payments);

    @Mapping(target = "user", source = "user")
    @Mapping(target = "order", source = "order")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Payment payment, Long amount, User user, Order order);
}
