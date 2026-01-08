package com.elementsandchill.payments.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class PaymentRequest {
    @NotBlank
    private String merchantId;

    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal amount;

    @NotBlank
    private String currency;

    @NotBlank
    private String source;
    // e.g., card number, wallet ID

    public PaymentRequest() {}

    public PaymentRequest(String merchantId, BigDecimal amount, String currency, String source) {
        this.merchantId = merchantId;
        this.amount = amount;
        this.currency = currency;
        this.source = source;
    }

    public String getMerchantId() { return merchantId; }
    public void setMerchantId(String merchantId) { this.merchantId = merchantId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) {
        this.currency = currency != null ? currency.toUpperCase() : null;
    }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
}