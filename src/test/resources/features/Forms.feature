Feature: Forms tests

  Background: Forms tests preconditions
    Given The user navigates to the Forms screen

  @regression @smoke
  Scenario: Verify Forms screen elements
    When The user verifies the Forms screen elements

  @regression @smoke
  Scenario: Verify active modal elements
    When The user verifies the Forms active modal elements

  @regression @smoke
  Scenario: Interact with Form elements
    When The user interact with the Form elements
    Then  The user verifies the result after interaction