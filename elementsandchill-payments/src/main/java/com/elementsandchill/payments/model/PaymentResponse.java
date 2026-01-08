package com.elementsandchill.payments.model;

import java.time.LocalDateTime;

public class PaymentResponse {
    private String transactionId;
    private String status; // AUTHORIZED, CAPTURED, REFUNDED
    private LocalDateTime timestamp;

    public PaymentResponse() {}

    public PaymentResponse(String transactionId, String status, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}