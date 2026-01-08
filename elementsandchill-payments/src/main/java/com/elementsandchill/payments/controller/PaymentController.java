package com.elementsandchill.payments.controller;

import com.elementsandchill.payments.model.*;
import com.elementsandchill.payments.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/authorize")
    public ResponseEntity<ApiResponse<PaymentResponse>> authorize(@Valid @RequestBody PaymentRequest request) {
        PaymentResponse paymentResponse = paymentService.authorize(request);

        ApiResponse<PaymentResponse> response = new ApiResponse<>(
                "SUCCESS",
                "Authorization successful",
                paymentResponse,
                Instant.now()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/capture/{id}")
    public ResponseEntity<ApiResponse<PaymentResponse>> capture(@PathVariable String id) {
        PaymentResponse paymentResponse = paymentService.capture(id);

        ApiResponse<PaymentResponse> response = new ApiResponse<>(
                "SUCCESS",
                "Capture successful",
                paymentResponse,
                Instant.now()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<ApiResponse<PaymentResponse>> getStatus(@PathVariable String id) {
        PaymentResponse paymentResponse = paymentService.getStatus(id);

        ApiResponse<PaymentResponse> response = new ApiResponse<>(
                "SUCCESS",
                "Status retrieved successfully",
                paymentResponse,
                Instant.now()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/payments")
    public ResponseEntity<String> getPayment(@RequestParam("paymentId") String paymentId) {
        return ResponseEntity.ok("Payment ID: " + paymentId);
    }

    @PostMapping("/refund")
    public ResponseEntity<ApiResponse<RefundResponse>> refund(@Valid @RequestBody RefundRequest refundRequest) {
        RefundResponse refundResponse = paymentService.refund(refundRequest);

        ApiResponse<RefundResponse> response = new ApiResponse<>(
                "SUCCESS",
                "Refund processed successfully",
                refundResponse,
                Instant.now()
        );

        return ResponseEntity.ok(response);
    }
}