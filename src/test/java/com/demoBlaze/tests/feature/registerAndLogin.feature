Feature: Login


  Scenario Outline: Register and login
    Given user will click on signup button
    And user will enter "<username>" and "<password>" and click on sign up button
    Then alert will appear with message "<alertMessage>" and validate that it was successfully created
    When user will click on login button
    And user will enter "<username>" and "<password>" and click on login button
    Then validate on the "<username>" is shown as the logged in user
    Examples:
      |username     | password     |alertMessage       |
      |testsss112236| testsss112236|Sign up successful.|