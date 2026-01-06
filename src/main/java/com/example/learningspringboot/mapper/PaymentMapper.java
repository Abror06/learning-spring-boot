package com.example.learningspringboot.mapper;

import com.example.learningspringboot.dto.*;
import com.example.learningspringboot.enums.PaymentStatus;
import com.example.learningspringboot.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.MappingTarget;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface PaymentMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "orderId", source = "order.id")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "status", source = "status")
    PaymentDto toDto(Payment payment);

    List<PaymentDto> toDto(List<Payment> payments);

    @Mapping(target = "user", source = "user")
    @Mapping(target = "order", source = "order")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "date", source = "localDateTime")
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "id", ignore = true)
    void toEntity(@MappingTarget Payment payment, Long amount, User user, Order order, LocalDateTime localDateTime);

    @Mapping(target = "user", source = "user")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", source = "status")
    void toUpdateEntity(@MappingTarget Payment payment, Long amount, User user, PaymentStatus status);

}
