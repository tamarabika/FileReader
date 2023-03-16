Feature: Test File Reader

  Scenario: Read file with more than 5 lines
    When I read a txt file with 6 lines
    Then I see 5 last lines


  Scenario: Read file with 5 lines
    When I read a text file with 5 lines
    Then I see all 5 lines


  Scenario: Read file with less than 5 lines
    When I read a text file with less than 5 lines
    Then I see less than 5 lines
