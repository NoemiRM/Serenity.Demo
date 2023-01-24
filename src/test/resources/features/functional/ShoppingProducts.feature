@Functional
Feature: User wants to buy products

  @Happy_path
  Scenario: User selects several products
    Given User "Juan Perez" is registered
    When User navigates to women's category page
    And User adds "Alphaboost shoes" product to shopping cart
      | quantity | 1      |
      | size     | L      |
      | color    | Purple |
    And User navigates to women's category page
    And User adds "Alphaedge 4d reflective shoes R" product to shopping cart
      | quantity | 2     |
      | size     | XL    |
      | color    | Black |
    And User navigates to women's category page
    And User adds "Edge gameday shoes" product to shopping cart
      | quantity | 3     |
      | size     | L     |
      | color    | Black |
    And User enters information to shipping address
      | fullName  | Juan Perez    |
      | telephone | 949456567     |
      | address   | str. 123      |
      | country   | United States |
      | province  | Alabama       |
      | postcode  | 300           |
    Then everShop page shows information about user's order
      | fullName  | Juan Perez                                                          |
      | telephone | 949456567                                                           |
      | address   | str. 123                                                            |
      | country   | Alabama, United States                                              |
      | postcode  | 300,                                                                |
      | products  | Alphaboost shoes,Alphaedge 4d reflective shoes R,Edge gameday shoes |









