@regression @search
Feature: Test Search Functionality

  Background: User is on the home page
    When user enters the url
    Then user is navigated to the login page

  Scenario Outline: Verify Movie Search
    When user enters <username> and <password>
    And user clicks on sign in button from sign in page
    Then user is navigated to the home page
    When user searches the <search text>
    Then system should display movies matching <search text> with movie title or actor or movie character

    Examples: 
      | username                     | password             | search text |
      | c2VsZW5pdW1AY3VjdW1iZXIuY29t | YXV0b21hdGlvbjEyMzQ= | batman      |
