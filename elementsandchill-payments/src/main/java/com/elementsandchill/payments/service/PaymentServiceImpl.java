package com.elementsandchill.payments.service;

import com.elementsandchill.payments.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentResponse authorize(PaymentRequest request) {
        return new PaymentResponse(
                UUID.randomUUID().toString(),
                "AUTHORIZED",
                LocalDateTime.now()
        );
    }

    @Override
    public PaymentResponse capture(String transactionId) {
        return new PaymentResponse(
                transactionId,
                "CAPTURED",
                LocalDateTime.now()
        );
    }

    @Override
    public RefundResponse refund(RefundRequest request) {
        return new RefundResponse(
                UUID.randomUUID().toString(),
                "REFUNDED",
                LocalDateTime.now()
        );
    }

    @Override
    public PaymentResponse getStatus(String transactionId) {
        return new PaymentResponse(
                transactionId,
                "STATUS_CHECKED",
                LocalDateTime.now()
        );
    }
}