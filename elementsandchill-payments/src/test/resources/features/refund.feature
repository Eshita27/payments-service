Feature: Refund a payment
  As a client
  I want to refund a captured payment
  So that the customer gets money back

  Scenario: Successful refund
    Given a valid refund request with transactionId "TXN456" and amount 250.00
    When I POST to "/payments/refund"
    Then the response status should be 200
    And the response body should contain "SUCCESS"
    And the response body should contain "Refund processed successfully"

  Scenario: Invalid refund amount
    Given a refund request with transactionId "TXN456" and amount 0.00
    When I POST to "/payments/refund"
    Then the response status should be 400
    And the response body should contain "Refund amount must be greater than 0"