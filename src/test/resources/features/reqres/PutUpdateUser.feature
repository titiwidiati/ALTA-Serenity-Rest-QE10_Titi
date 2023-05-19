Feature: Reqres API Put Update User
  @Tugas
  Scenario: Put update user with invalid ID and invalid body json
    Given Put update user with invalid id "yyxxzz" and invalid json
    When Send put update user
    Then Status code should be 400 Bad Request