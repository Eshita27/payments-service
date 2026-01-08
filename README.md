# Payments-Service API

## 📖 Overview
The Payments-Service API is a Spring Boot application designed to handle core payment flows including initiation, authorization, capture, refund, and reconciliation. It also supports integration with mock gateways to simulate real-world scenarios for QA automation.

---

## ⚙️ Features
- **Payment Lifecycle**: Initiate → Authorize → Capture → Refund → Status
- **Mock Gateway Stub**: Simulates success, failure, and timeout responses
- **Standards Support**:
  - PCI DSS compliance (data masking, audit logging)
  - ISO 20022 message parsing
  - SWIFT MT/MX message simulation
- **Automation Ready**: JUnit + RestAssured + Cucumber for API-level testing

---

## 🏗️ Project Structure
com.elementsandchill.payments
├── controller/       # REST endpoints
├── service/          # Business logic
├── model/            # Request/response POJOs
├── repository/       # Persistence layer (if DB needed)
├── config/           # Gateway configs, security
└── utils/            # Parsers, helpers (ISO20022, SWIFT)

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+
- IntelliJ IDEA (recommended)

### Running Locally
```bash
mvn spring-boot:run

API Endpoints
- POST /payments/initiate
- POST /payments/authorize
- POST /payments/capture
- POST /payments/refund
- GET  /payments/status/{txnId}
- POST /payments/webhook


