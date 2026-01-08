package com.elementsandchill.payments.model;

import java.time.Instant;

public class ApiResponse<T> {
    private String status;   // SUCCESS / ERROR
    private String message;  // human-readable
    private T data;          // actual payload
    private Instant timestamp;

    public ApiResponse() {}

    public ApiResponse(String status, String message, T data, Instant timestamp) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    // getters and setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}