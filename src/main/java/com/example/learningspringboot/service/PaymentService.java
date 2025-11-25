package com.example.learningspringboot.service;

import com.example.learningspringboot.dto.PaymentCreateDto;
import com.example.learningspringboot.dto.PaymentDto;
import com.example.learningspringboot.exception.*;
import com.example.learningspringboot.mapper.PaymentMapper;
import com.example.learningspringboot.model.Order;
import com.example.learningspringboot.model.Payment;
import com.example.learningspringboot.model.User;
import com.example.learningspringboot.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserService userService;
    private final OrderService orderService;
    private final PaymentMapper paymentMapper;


    public List<PaymentDto> findAll() {
        List<Payment> allPayments = paymentRepository.findAll();
        return paymentMapper.toDto(allPayments);
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
        persist(payment, dto.getUserId(), dto.getOrderId(), dto.getAmount());
        return paymentMapper.toDto(payment);
    }

    public void delete(Long id) {
        Payment payment = findById(id);

        paymentRepository.delete(payment);
    }

    public Payment updatePayment(Long paymentId, Long userId, Long orderId, Long amount) {
        Payment payment = findById(paymentId);
        return persist(payment, userId, orderId, amount);
    }

    private void checkAmount(Long amount) {
        if (amount < 1) {
            throw new IllegalAmountException("Amount must be more than 0 ");
        }
    }

    private Payment persist(Payment payment, Long userId, Long orderId, Long amount) {
        checkAmount(amount);

        User user = userService.findById(userId);
        Order order = orderService.findById(orderId);

        paymentMapper.updateEntity(payment, amount, user, order);

        return paymentRepository.save(payment);
    }
}
