Feature: Test File Reader
  Scenario: Read 6 lines from .txt file
    When I read txt file
    Then I see 5 last lines

