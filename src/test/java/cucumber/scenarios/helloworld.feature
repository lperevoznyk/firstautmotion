Feature: Log in

  As a non logged user
  I want to login
  So I can use the internet
  Scenario: Valid login test
    Given user open the internet login page
    When user enters 'tomsmith' in login field and 'SuperSecretPassword!' in password
    And clicks 'Login' button
    Then user is logged in

  @SecondBefore @CartPageTests
  Scenario Outline: Negative login test
    Given user open the internet login page
    When user enters '<login>' in login field and '<password>' in password
    And clicks 'Login' button
    Then user sees error message 'qweqweqwe'

    Examples:
      | login     | password            |
      | qweqwe    | SuperSecretPassword |
      | tomsmith  | qweqwe              |
      | qweqweqwe | qweqwe              |