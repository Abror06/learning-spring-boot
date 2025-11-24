package com.example.learningspringboot.controller;


import com.example.learningspringboot.dto.PaymentCreateDto;
import com.example.learningspringboot.dto.PaymentDto;
import com.example.learningspringboot.model.Payment;
import com.example.learningspringboot.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDto>> getALl() {
        List<PaymentDto> payments = paymentService.findAll();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> getById(@PathVariable("id") Long id) {
        PaymentDto payment = paymentService.findPaymentDtoById(id);
        return ResponseEntity.ok(payment);
    }

    @PostMapping
    public ResponseEntity<PaymentDto> createPayment(@RequestBody @Valid PaymentCreateDto dto) {
        PaymentDto payment = paymentService.createPayment(dto);
        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable(value = "id") Long id, @RequestParam(value = "userId", required = false) Long userId, @RequestParam(value = "orderId", required = false) Long orderId, @RequestParam(value = "amount", required = false) Long amount) {
        Payment payment = paymentService.updatePayment(id, userId, orderId, amount);
        return ResponseEntity.ok(payment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable(value = "id") Long id) {
        paymentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
