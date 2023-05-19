Feature: Reqres API Patch Update User
  @Tugas
  Scenario Outline: Patch update user with valid body json and parameter ID
    Given Patch update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body update name was "morpheus" and job was "zion resident"
    And Validate update user JSON Schema
  Examples:
    | id |
    | 1  |
    | 2  |
    | 3  |