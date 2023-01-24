# new feature
# Tags: optional

@Integration
Feature: Get information of Country

  Scenario Outline: Country's info
    Given User has right access to use the service
    Then User requests information "<alpha2Code>" alpha code
    Given Service returns with country's information
      | name       | <name>       |
      | alpha2Code | <alpha2Code> |
      | capital    | <capital>    |
    And Service returns OK status 200
    Examples:
      | alpha2Code | name                     | capital          |
 #     | US         | United States of America | Washington, D.C. |
      | DE         | United States of America | Washington, D.C. |
#      | GB         | United States of America | Washington, D.C. |
