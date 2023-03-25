Feature: Test File Reader

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
