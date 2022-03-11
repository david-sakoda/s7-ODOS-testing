@regression @logout
Feature: Test Logout Functionality

  Background: User is on the login page
    When user enters the url
    Then user is navigated to the login page

  Scenario Outline: Check logout successful
    When user enters <username> and <password>
    And user clicks on sign in button from sign in page
    Then user is navigated to the home page
    When user clicks user logo from home page
    Then logout button should display
    When user clicks logout button
    Then user is navigated to the login page

    Examples: 
      | username                     | password             | search text 
      | c2VsZW5pdW1AY3VjdW1iZXIuY29t | YXV0b21hdGlvbjEyMzQ= |
