@tag1
Feature: User Login
  As a user
  I want to log in to the e-commerce platform
  So that I can access my account and shop online

  @test1
  Scenario Outline: Successful login with valid credentials
    Given I am on the homepage using "<browser>"
    And I navigate to the Magento-demo.mageplaza.com login page
    When I enter a "<email>" and "<password>"
    And I click the signin button
    Then I should see my account dashboard

    Examples: 
      | browser | email                 | password      |
      | chrome  | rurusa@mailinator.com | 7vq@uVrnd9V52 |
      | firefox | rurusa@mailinator.com | 7vq@uVrnd9V52 |
#      | edge    | rurusa@mailinator.com | 7vq@uVrnd9V52 |
     

  @test2
  Scenario Outline: Login with invalid credentials
    Given I am on the homepage using "<browser>"
    And I navigate to the Magento-demo.mageplaza.com login page
    When I enter a "<email>" and "<password>"
    And I click the signin button
    Then I should see invalid email error message

    Examples: 
      | browser | email             | password      |
      | chrome  | rurusa@mailinator | 7vq@uVrnd9V52 |
      | firefox | rurusa@mailinator | 7vq@uVrnd9V52 |
#      | edge    | rurusa@mailinator | 7vq@uVrnd9V52 |
  