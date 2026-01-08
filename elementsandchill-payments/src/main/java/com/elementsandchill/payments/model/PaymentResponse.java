package com.elementsandchill.payments.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class PaymentResponse {
    private String transactionId;
    private String status; // AUTHORIZED, CAPTURED, REFUNDED
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
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