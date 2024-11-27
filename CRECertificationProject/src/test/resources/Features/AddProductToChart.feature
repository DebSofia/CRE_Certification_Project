@tag4
Feature: Add Item to Shopping Cart
  As a user
  I want to add items to my shopping cart
  So that I can proceed to purchase them later

  @test1
  Scenario Outline: Adding a product to the cart
    Given I am on the homepage using "<browser>"
    And I enter "<searchTerm>" in the search bar
    And I select the first item after searching "<searchTerm>"
    When I click on the Add to cart button
    And I click on the cart icon
    Then I should see a clickable proceed to checkout button

    Examples: 
      | browser | searchTerm |   
      | chrome  | bags       |
      | firefox | bags       |
#      | edge    | bags       |
  

