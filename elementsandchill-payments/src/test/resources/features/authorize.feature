Feature: Authorize a payment
  As a client
  I want to authorize a payment
  So that I can capture it later

  Scenario: Successful authorization
    Given a valid payment request with source "UPI" and merchantId "MERCHANT123"
    When I POST to "/payments/authorize"
    Then the response status should be 200
    And the response body should contain "SUCCESS"
    And the response body should contain "Authorization successful"

  Scenario: Missing required fields
    Given a payment request missing "source"
    When I POST to "/payments/authorize"
    Then the response status should be 400
    And the response body should contain "Validation failed"