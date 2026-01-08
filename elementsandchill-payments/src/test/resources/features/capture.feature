Feature: Capture a payment
  As a client
  I want to capture an authorized payment
  So that funds are settled

  Scenario: Successful capture
    Given a valid transactionId "TXN456"
    When I POST to "/payments/capture/TXN456"
    Then the response status should be 200
    And the response body should contain "SUCCESS"
    And the response body should contain "Capture successful"

  Scenario: Invalid transactionId
    Given an invalid transactionId "INVALID123"
    When I POST to "/payments/capture/INVALID123"
    Then the response status should be 404
    And the response body should contain "ERROR"