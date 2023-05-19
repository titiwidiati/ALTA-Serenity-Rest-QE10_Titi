Feature: Reqres API Get Single User
  @Tugas
  Scenario Outline: Get single user with valid parameter ID
    Given Get single user with valid parameter ID <id>
    When Send get single user
    Then Status code should be 200 OK
    And Response body id should be <id>
    And Validate get single user JSON Schema
  Examples:
    | id |
    | 1  |
    | 2  |

  @Tugas
  Scenario: Get single user with exceed parameter ID
    Given Get single user with invalid parameter ID 23
    When Send get single user
    Then Status code should be 404 Not Found