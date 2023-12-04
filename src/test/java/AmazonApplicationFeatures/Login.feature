Feature: Login to Amazon

  Scenario Outline: Login Validation with valid credentials
    Given User is on the Amazon home page
    When User clicks on the Sign in button
    And User enters "<username>" and "<password>"
    And User clicks the Sign in button
    Then User should be logged in and see the Amazon dashboard

    Examples:
      | username          | password        |
      | 8961306475        | Shahid@1995     |
     