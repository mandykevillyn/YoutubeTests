Feature: Login

  Background: 
    Given user is on Youtube page

  Scenario: Check login is successful with valid credentials
    Given user clicks on login
    When user enters a valid email
    And user enters a valid password
    Then user is navigated to the homepage

  Scenario Outline: Try to login with invalid email
    Given user clicks on login
    When user enters a invalid <email>
    And user clicks on Next button
    Then a error message invalid account is raised

    Examples: 
      | email          |
      | '!@!'          |
      | 'aaaa@dominio' |


  Scenario Outline: Try to login with a invalid password
    Given user clicks on login
    When user enters a valid email
    And user enters a invalid  password <password>
    Then a error message invalid password is raised

    Examples: 
      | password |
      | '111111' |
