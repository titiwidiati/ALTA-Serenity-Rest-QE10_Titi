Feature: Reqres API Post Login User
  @Tugas
  Scenario: Post login user with valid body json
    Given Post login user with valid json
    When Send post login user
    Then Status code should be 200 OK
    And Response body token should be "QpwL5tke4Pnpja7X4"
    And Validate login user JSON Schema

  @Tugas
  Scenario: Post login user with invalid json
    Given Post login user with invalid json
    When Send post login user
    Then Status code should be 400 Bad Request
    And Response body error should be "Missing password"
    And Validate invalid login user JSON Schema

