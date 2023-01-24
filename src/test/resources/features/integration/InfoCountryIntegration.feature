# new feature
# Tags: optional

@Integration
Feature: Get information of Country

  Scenario Outline: Country's info
    Given User has right access to use the service
    Then User requests information "<alpha2Code>" alpha code
    Given Service returns OK status 200
    And Service returns with country's information
      | name       | <name>       |
      | alpha2Code | <alpha2Code> |
      | capital    | <capital>    |
    Examples:
      | alpha2Code | name                                                 | capital          |
      | US         | United States of America                             | Washington, D.C. |
      | DE         | Germany                                              | Berlin           |
      | GB         | United Kingdom of Great Britain and Northern Ireland | London           |
