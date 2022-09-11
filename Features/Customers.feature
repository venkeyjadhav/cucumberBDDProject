Feature: customers

Background: steps common for all senarios
    Given user launch chrome browser
    When user open url "https://admin-demo.nopcommerce.com/login"
    And user enter email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then user can view Dashboad
  @Sanity
  Scenario: Add New Customer
    When click on customer menu
    And click on customer menu item
    And click on add new button
    Then user can see add new customer page
    When user enter customer info
    And click on save button
    Then user can see conformation msg "The new customer has been added successfully."
    And close browser
  @regression
  Scenario: Search customer by email
    When click on customer menu
    And click on customer menu item
    And enter customer email
    When click on search button
    And close browser
  @Sanity
  Scenario: Search customer by Name
    When click on customer menu
    And click on customer menu item
    And enter customer firstname
    And enter customer lastname
    When click on search button
    And close browser
