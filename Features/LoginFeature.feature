Feature: login
  @Sanity 
  Scenario: Successful login with valid creadentials
    Given user launch chrome browser
    When user open url "https://admin-demo.nopcommerce.com/login"
    And user enter email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user click on log out link
    And close the browser

  @regression
  Scenario Outline: Successful login with valid creadentials DDT
    Given user launch chrome browser
    When user open url "https://admin-demo.nopcommerce.com/login"
    And user enter email as "<email>" and password as "<password>"
    And click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user click on log out link
    And close the browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
     # | admin@yourstore.com | admin1   |
