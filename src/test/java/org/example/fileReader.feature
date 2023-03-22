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
    When I read an img file
    Then I see error img file message

  Scenario: Read file with special characters
    When I read a txt file with special characters
    Then I see error special characters file message


  Scenario Outline: Read a valid txt file
    When I read the file <name>
    Then I should see the last 5 lines
    """
   <expected_output>
    """
    Examples:
      | name            | expected_output               |
      | file6-lines.txt | 2LINE 3LINE 4LINE 5LINE 6LINE |
      | file5-lines.txt | 1LINE 2LINE 3LINE 4LINE 5LINE |


  Scenario Outline: Read a invalid file
    When I read the file <name>
    Then I should see the <expected_message> massage
    """
   <expected_message>
    """
    Examples:
      | name                       | expected_message                     |
      | file4-lines.txt            | File has less than 5 lines           |
      | empty-file.txt             | The file is empty                    |
      | file-picSmile.img          | The file is not a text file          |
      | file-specialCharacters.txt | The file contains special characters |
