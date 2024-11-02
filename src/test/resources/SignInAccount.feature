Feature: User Sign In

  Scenario: Sign in with valid email and password
    Given open hint official website
    When closes the popup banner
    And click the profile icon
    And input valid email
    And input valid password
    And click sign in button
    Then profile icon change to profile login icon