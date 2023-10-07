Feature: Login


  Scenario Outline: Adding random item to the cart and removing it
    Given user will click on login button
    And user will enter "<username>" and "<password>" and click on login button
    Then validate on the "<username>" is shown as the logged in user
    When random item is selected
    And click on add to cart button
    Then alert will appear with message "<Message>" that item is added successfully
    When clicking on cart button in the home page
    And removing the item added from the cart page

    Examples:
      |username     | password     |Message|
      |testsss112236| testsss112236|Product added.|