Feature: Test File Reader

  Scenario: Read file with more than 5 lines
    When I read a txt file with 6 lines
    Then I see 5 last lines


  Scenario: Read file with 5 lines
    When I read a text file with 5 lines
    Then I see all 5 lines


  Scenario: Read file with less than 5 lines
    When I read a text file with less than 5 lines
    Then I see error message

  Scenario: Read empty file
    When I read a text empty file
    Then I see error empty file message

  Scenario: Read img file
    When I read a img file
    Then I see error img file message


  Scenario: Read file with special characters
    When I read a txt file with special characters
    Then I see error special characters file message