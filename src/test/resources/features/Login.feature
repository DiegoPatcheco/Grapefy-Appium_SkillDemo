Feature: Login tests

  Background: Login tests preconditions
    Given The user navigates to the Login screen

  @regression @smoke
  Scenario: Verify Login screen elements
    When The user verifies the Login screen elements

  @regression @smoke
  Scenario: Verify Sign Up screen elements
    When The user verifies the Sign Up screen elements

  @regression @smoke
  Scenario: User Logs in with valid data
    When The user fills the Login form with valid data
    Then The user verifies the Login success message

  @regression @smoke
  Scenario Outline: : User Logs in with invalid data
    When The user fills the Login form with invalid data: <email> email, <password> password
    Then The user verifies the Login error message: <errorMessage>
    Examples:
      | email                           | password                  | errorMessage                         |
      | ""                              | "holaholablassacademy123" | "Please enter a valid email address" |
      | "blass_academy_forever@wow.com" | ""                        | "Please enter at least 8 characters" |

  @regression @smoke
  Scenario Outline: : User Signs Up with invalid data
    When The user fills the Sign Up form with invalid data: <email> email, <password> password, <pwdConfirm> password confirm
    Then The user verifies the Login error message: <errorMessage>
    Examples:
      | email                           | password            | pwdConfirm          | errorMessage                         |
      | "blass_academy_forever@wow.com" | "holaholapassword1" | ""                  | "Please enter the same password"     |
      | "blass_academy_forever@wow.com" | ""                  | "holaholapassword1" | "Please enter at least 8 characters" |
      | ""                              | "holaholapassword1" | "holaholapassword2" | "Please enter a valid email address" |