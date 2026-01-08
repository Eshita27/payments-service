package com.elementsandchill.payments.service;

import com.elementsandchill.payments.model.*;

public interface PaymentService {
    PaymentResponse authorize(PaymentRequest request);
    PaymentResponse capture(String transactionId);
    RefundResponse refund(RefundRequest request);
    PaymentResponse getStatus(String transactionId);
}