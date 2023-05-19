Feature: Reqres API Post Register User
  @Tugas
  Scenario: Post register user with valid body json
    Given Post register user with valid json
    When Send post register user
    Then Status code should be 200 OK
    And Response body id should be 4 and token should be "QpwL5tke4Pnpja7X4"
    And Validate register user JSON Schema

  @Tugas
  Scenario: Post register user with invalid body json
    Given Post register user with invalid json
    When Send post register user
    Then Status code should be 400 Bad Request
    And Response body error should be "Missing password"
    And Validate invalid register user JSON Schema