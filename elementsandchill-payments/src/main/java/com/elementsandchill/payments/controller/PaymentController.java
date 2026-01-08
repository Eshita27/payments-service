package com.elementsandchill.payments.controller;

import com.elementsandchill.payments.model.*;
import com.elementsandchill.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/authorize")
    public ResponseEntity<PaymentResponse> authorize(@Valid @RequestBody PaymentRequest request) {
        PaymentResponse response = paymentService.authorize(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/capture/{id}")
    public ResponseEntity<PaymentResponse> capture(@PathVariable String id) {
        PaymentResponse response = paymentService.capture(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/refund")
    public ResponseEntity<RefundResponse> refund(@RequestBody RefundRequest request) {
        RefundResponse response = paymentService.refund(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<PaymentResponse> getStatus(@PathVariable String id) {
        PaymentResponse response = paymentService.getStatus(id);
        return ResponseEntity.ok(response);
    }
}