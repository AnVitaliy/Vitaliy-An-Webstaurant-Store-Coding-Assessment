@QA_Regression
Feature: Testing Search Functionality Of Webstaurant Store

  Scenario:  Happy Path (positive) Testing Result from Search
    Given User search for 'stainless work table'
    Then User validates that each product title contains word 'Table'
    And User adds last item to cart and clears the cart to validate message 'Your cart is empty.'





