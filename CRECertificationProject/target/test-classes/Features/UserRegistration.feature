@tag2
Feature: New User Registration
  As a new user
  I want to create an account
  So that I can shop online and manage my purchases

  @test1
  Scenario Outline: Successful user registration
    Given I am on the homepage using "<browser>"
    And I navigate to the Create an account page
    When I fill in account registration with valid values
    And I click the Create an Account button
    Then I should see a success message
    And I should be redirected to the account dashboard

    Examples: 
      | browser |
      | chrome  |
      | firefox |
#      | edge    |
      

  @test2
  Scenario Outline: Registration with missing required fields
    Given I am on the homepage using "<browser>"
    And I navigate to the Create an account page
    When I fill in account registration with invalid email
    And I click the Create an Account button
    Then It should display an error message "Please enter a valid email address (Ex: johndoe@domain.com)."

    Examples: 
      | browser |
      | chrome  |
      | firefox |
 #     | edge    |
     
