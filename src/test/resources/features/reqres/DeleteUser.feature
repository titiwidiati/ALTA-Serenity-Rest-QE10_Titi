Feature: Reqres API Delete User
  @Tugas
  Scenario Outline: Delete user with exceed id
    Given Delete user with exceed id <id>
    When Send delete user
    Then Status code should be 404 Not Found
  Examples:
    | id  |
    | 200 |
    | 300 |