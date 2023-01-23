Feature: Login

  @functional
  Scenario: Login
    Given User "Juan Perez" is registered
    And User is at Home Page
    When User requests to login with right access
    Then Application shows user page
