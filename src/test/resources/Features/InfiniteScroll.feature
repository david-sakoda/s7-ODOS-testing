@regression @infinitescroll
Feature: Test Search Functionality

  Background: User is on the home page
    When user enters the url
    Then user is navigated to the login page

  Scenario Outline: Verify Movie Search
    When user enters <username> and <password>
    And user clicks on sign in button from sign in page
    Then user is navigated to the home page
    And system should display fifteen random dossiers
    When user scrolls down to the very bottom dossier
    Then system should load fifteen more dossiers

    Examples: 
      | username                     | password             |
      | c2VsZW5pdW1AY3VjdW1iZXIuY29t | YXV0b21hdGlvbjEyMzQ= |
