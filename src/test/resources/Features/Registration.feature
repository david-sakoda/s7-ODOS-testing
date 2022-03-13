@regression @registration
Feature: Test Registration Functionality

  Background: User is on the login page
    When user enters the url
    Then user is navigated to the login page
    When user clicks on register button
    Then user is navigated to the registration page

  Scenario Outline: Check registration is successful with valid registration information
    When user enters <firstname> , <lastname> , <email> , <password> , <group membership>
    And user clicks on register button from registration page
    Then user is navigated to the home page
    Then <firstname> and <lastname> are displayed on the header of the application
    And <group membership> is displayed on header user information dropdown

    Examples: 
      | firstname | lastname | email  | password       | group membership |
      | Selenium  | Cucumber | random | automation1234 | Users            |
      | Selenium  | Cucumber | random | automation1234 | Supervisors      |

  Scenario Outline: Check system displays belonging the error for the invalid registration information
    And user clicks on register button from registration page
    Then system should display the belonging error for the invalid registration information
    When user enters an invalid email to the email inputbox
    And user clicks on register button from registration page
    Then system should display invalid email address error
    When user enters a non matching password for the password inputboxes
    And user clicks on register button from registration page
    Then system should display password does not match error
