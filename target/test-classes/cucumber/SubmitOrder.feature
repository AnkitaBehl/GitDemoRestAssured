
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
   Background:
   Given I landed on Ecommerce Page
 
  @tag2
  Scenario Outline: Positive Test of Submitting the order
  
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationaPage

    Examples: 
      | name                    | password		  | productName     |
      | testing1526@yahoo.com   | Automation12@ | ADIDAS ORIGINAL |
      
