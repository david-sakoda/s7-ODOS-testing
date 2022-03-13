@regression @dossier
Feature: Test Dossiers

  Background: User is on the home page
    When user enters the url
    Then user is navigated to the login page

  Scenario Outline: Verify twenty random dossiers are displayed on the main page
    When user enters <username> and <password>
    And user clicks on sign in button from sign in page
    Then user is navigated to the home page
    And system should display fifteen random dossiers
    Then system should display movie information for each dossier

    Examples: 
      | username                     | password             |
      | c2VsZW5pdW1AY3VjdW1iZXIuY29t | YXV0b21hdGlvbjEyMzQ= |

  Scenario Outline: Verify dossier page content is displayed
    When user enters <username> and <password>
    And user clicks on sign in button from sign in page
    Then user is navigated to the home page
    Then user clicks on view dossier button and user is navigated to the belonging dossier for each dossier displayed on the page

    Examples: 
      | username                     | password             |
      | c2VsZW5pdW1AY3VjdW1iZXIuY29t | YXV0b21hdGlvbjEyMzQ= |
