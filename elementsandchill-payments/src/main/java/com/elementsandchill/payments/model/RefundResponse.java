package com.elementsandchill.payments.model;

import java.time.LocalDateTime;

public class RefundResponse {
    private String refundId;
    private String status; // REFUNDED, FAILED
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