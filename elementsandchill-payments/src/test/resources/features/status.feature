Feature: Check payment status
  As a client
  I want to check the status of a payment
  So that I know if it is authorized, captured, or refunded

  Scenario: Successful status inquiry
    Given a valid paymentId "PAY789"
    When I GET "/payments/status/PAY789"
    Then the response status should be 200
    And the response body should contain "SUCCESS"
    And the response body should contain "Status retrieved successfully"

  Scenario: Unknown paymentId
    Given an invalid paymentId "UNKNOWN123"
    When I GET "/payments/status/UNKNOWN123"
    Then the response status should be 404
    And the response body should contain "ERROR"