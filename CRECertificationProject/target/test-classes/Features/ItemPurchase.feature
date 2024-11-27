@tag5
Feature: Product Purchase
  As a user
  I want to complete the purchase of items in my shopping cart
  So that I can receive my order

  @test1
  Scenario Outline: Successful purchase of a product
    Given I am on the homepage using "<browser>"
    And I am autenticated with "<email>" and "<password>"
    And I add a product to the cart using "<search term>"
    When I proceed to checkout
    And I already have my account details filled
    And I select a payment method
    And I confirm the order
    Then I should see a confirmation message "Your order has been placed"

    Examples: 
      | browser | email                 | password      | search term |
      | chrome  | rurusa@mailinator.com | 7vq@uVrnd9V52 | bags        |
      | firefox | rurusa@mailinator.com | 7vq@uVrnd9V52 | bags        |
#      | edge    | rurusa@mailinator.com | 7vq@uVrnd9V52 | bags        |
  
      
