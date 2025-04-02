Feature: Drag tests

  Background: Drag tests preconditions
    Given The user navigates to the Drag screen

  @regression @smoke
  Scenario: Verify Drag screen elements
    When The user verifies the Drag screen elements

  @regression @smoke
  Scenario: Build image puzzle
    When The user builds the image puzzle
    Then The user verifies the congratulations screen