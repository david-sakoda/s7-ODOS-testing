@regression @login
Feature: Test Login Functionality

  Background: User is on the login page
    When user enters the url
    Then user is navigated to the login page

  Scenario Outline: Check login is successful with valid credentials
    When user enters <username> and <password>
    And user clicks on sign in button from sign in page
    Then user is navigated to the home page

    Examples: 
      | username                     | password             |
      | c2VsZW5pdW1AY3VjdW1iZXIuY29t | YXV0b21hdGlvbjEyMzQ= |

  Scenario Outline: Check login is unsuccessful with invalid credentials
    When user enters <username> and <password>
    And user clicks on sign in button from sign in page
    Then system should display invalid username or password error

    Examples: 
      | username         | password             |
      | dGVzdGFjY291bnQy | YXV0b21hdGlvbjEyMzQ= |
