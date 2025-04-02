Feature: Home tests

  Background: Home tests preconditions
    Given The user navigates to the Home screen

  @regression @smoke
  Scenario: Verify Home screen elements
    Then The user verifies the Home screen elements

  @regression @smoke
  Scenario: Verify Bottom bar elements
    Then The user verifies the Bottom bar elements