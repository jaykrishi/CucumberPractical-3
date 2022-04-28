@Color
Feature: Setting Background Color

  Background: 
    Given User is on Techfios Page
    And Set SkyBlue BackGround Button Exists
    And Set SkyWhite BackGround Button Exists

  
  Scenario: User should be able to change background color to Sky Blue
    When User clicks on the Set SkyBlue Button
    Then Background Color changes to Sky Blue

    Scenario: User shouls be able to change background color to White
    When User clicks on the Set SkyWhite Button
    Then Background Color changes to White
