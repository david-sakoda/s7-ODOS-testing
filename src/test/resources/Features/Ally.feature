@ally
Feature: Accessibility testing for ODOS Challenge App

  Background: User is on the login page
    When user enters the url
    Then user is navigated to the login page

  Scenario: Accessibility testing for the login page
    When test accessibility for the login page

  Scenario: Accessibility testing for the registration page
    When user clicks on register button
    Then user is navigated to the registration page
    When test accessibility for the registration page

  Scenario Outline: Accessibility testing for the home page
    When user enters <username> and <password>
    And user clicks on sign in button from sign in page
    Then user is navigated to the home page
    When test accessibility for the home page

    Examples: 
      | username                     | password             |
      | c2VsZW5pdW1AY3VjdW1iZXIuY29t | YXV0b21hdGlvbjEyMzQ= |

  Scenario Outline: Accessibility testing for the dossier page
    When user enters <username> and <password>
    And user clicks on sign in button from sign in page
    Then user is navigated to the home page
    Then user clicks on one of the movie dossiers
    When test accessibility for the dossier page

    Examples: 
      | username                     | password             |
      | c2VsZW5pdW1AY3VjdW1iZXIuY29t | YXV0b21hdGlvbjEyMzQ= |
