Feature: Login


  Scenario Outline: Checking the listed categories has items
    Given user will click on login button
    And user will enter "<username>" and "<password>" and click on login button
    Then validate on the "<username>" is shown as the logged in user
    When clicking on laptops category lots of list items will be shown
    Then validate that selected category has items
    When clicking on mobiles category lots of list items will be shown
    Then validate that selected category has items
    When clicking on monitors category lots of list items will be shown
    Then validate that selected category has items

    Examples:
      |username     | password     |
      |testsss112236| testsss112236|