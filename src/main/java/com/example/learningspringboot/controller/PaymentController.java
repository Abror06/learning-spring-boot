package com.example.learningspringboot.controller;


import com.example.learningspringboot.dto.PaymentCreateDto;
import com.example.learningspringboot.dto.PaymentDto;
import com.example.learningspringboot.dto.PaymentUpdateDto;
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
        PaymentDto paymentDto = paymentService.createPayment(dto);
        return new ResponseEntity<>(paymentDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDto> updatePayment(@PathVariable(value = "id") Long id, @RequestBody @Valid PaymentUpdateDto dto) {
        PaymentDto paymentDto = paymentService.updateById(id, dto);
        return ResponseEntity.ok(paymentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable(value = "id") Long id) {
        paymentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
