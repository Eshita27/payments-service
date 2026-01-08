package com.elementsandchill.payments.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class RefundResponse {
    @NotBlank(message = "Refund ID is required")
    private String refundId;

    @NotBlank(message = "Status is required")
    private String status;// REFUNDED, FAILED
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public RefundResponse() {}

    public RefundResponse(String refundId, String status, LocalDateTime timestamp) {
        this.refundId = refundId;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getRefundId() { return refundId; }
    public void setRefundId(String refundId) { this.refundId = refundId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}