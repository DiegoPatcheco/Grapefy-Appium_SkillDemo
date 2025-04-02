Feature: Swipe tests

  Background: Swipe tests preconditions
    Given The user navigates to the Swipe screen

  @regression @smoke
  Scenario: Verify Swipe screen elements
    When The user verifies the Swipe screen elements

  @regression @smoke
  Scenario: Verify single carousel item
    When The user performs 3 left swipes
    Then The user verifies the 3 carousel item elements

  @regression @smoke
  Scenario: Verify robot elements
    When The user performs 2 up swipes
    Then The user verifies the robot elements