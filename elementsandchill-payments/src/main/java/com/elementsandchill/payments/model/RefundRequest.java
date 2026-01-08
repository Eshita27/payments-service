package com.elementsandchill.payments.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class RefundRequest {
    @NotBlank(message = "Transaction ID is required")
    private String transactionId;

    @DecimalMin(value = "0.01", message = "Refund amount must be greater than 0")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal amount;



    public RefundRequest() {}

    public RefundRequest(String transactionId, BigDecimal amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}