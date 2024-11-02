Feature: Order

  Scenario: User order product
    Given User sign in
    When User open product detail
    And Checkout product
    And Complete Order
    Then User get order id