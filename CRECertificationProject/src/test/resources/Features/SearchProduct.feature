@tag3
Feature: Search and Visualize Item
  As a user
  I want to search for products
  So that I can find and view the details of an item I want to purchase

  @test1
  Scenario Outline: Successful search for an existing product
    Given I am on the homepage using "<browser>"
    When I enter "<searchTerm>" in the search bar
    And I click the "Search" button icon
    Then I should see a list of products related to "<searchTerm>"

    Examples: 
      | browser | searchTerm |
      | chrome  | watches    |
      | firefox | watches    |
#      | edge    | watches    |
  
      

  @test2
  Scenario Outline: Viewing product details
    Given I am on the homepage using "<browser>"
    And I searched for "<searchTerm>" and results are displayed
    When I click on the first item
    Then I should be redirected to the product details page for "<name>"
    And I should see the "<name>", "<price>", "<description>"

    Examples: 
      | browser | searchTerm | name               | price  | description |
      | chrome  | watches    | Dash Digital Watch | $92.00 | Details     |
      | firefox | watches    | Dash Digital Watch | $92.00 | Details     |
#      | edge    | watches    | Dash Digital Watch | $92.00 | Details     |
     