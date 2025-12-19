package com.example.learningspringboot.service;

import com.example.learningspringboot.dto.PaymentCreateDto;
import com.example.learningspringboot.dto.PaymentDto;
import com.example.learningspringboot.dto.PaymentUpdateDto;
import com.example.learningspringboot.enums.PaymentStatus;
import com.example.learningspringboot.exception.*;
import com.example.learningspringboot.mapper.PaymentMapper;
import com.example.learningspringboot.model.Order;
import com.example.learningspringboot.model.Payment;
import com.example.learningspringboot.model.User;
import com.example.learningspringboot.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserService userService;
    private final OrderService orderService;
    private final PaymentMapper paymentMapper;


    public Page<PaymentDto> findAll(Pageable pageable) {
        Page<Payment> paymentPage = paymentRepository.findAll(pageable);

        Page<PaymentDto> dtoPage = paymentPage.map(paymentMapper::toDto);
        return dtoPage;
    }

    public Payment findById(Long id) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {
            return optionalPayment.get();
        }
        throw new PaymentNotFoundException("payment not found");
    }

    public PaymentDto findPaymentDtoById(Long id) {
        return paymentMapper.toDto(findById(id));
    }

    public PaymentDto createPayment(PaymentCreateDto dto) {
        Payment payment = new Payment();
        return paymentMapper.toDto(persist(payment, dto.getUserId(), dto.getOrderId(), dto.getAmount()));
    }

    public void delete(Long id) {
        Payment payment = findById(id);

        paymentRepository.delete(payment);
    }

    public PaymentDto updateById(Long id, PaymentUpdateDto dto) {
        Payment payment = findById(id);
        return paymentMapper.toDto(persistToUpdate(payment, dto.getUserId(), dto.getAmount(), dto.getStatus()));
    }

    private Payment persist(Payment payment, Long userId, Long orderId, Long amount) {

        User user = userService.findById(userId);
        Order order = orderService.findById(orderId);

        paymentMapper.toEntity(payment, amount, user, order, LocalDateTime.now());

        return paymentRepository.save(payment);
    }

    private Payment persistToUpdate(Payment payment, Long userId, Long amount, PaymentStatus status) {
        User user = null;

        if (userId != null) {
            user = userService.findById(userId);
        }
        paymentMapper.toUpdateEntity(payment, amount, user, status);
        return paymentRepository.save(payment);
    }
}
