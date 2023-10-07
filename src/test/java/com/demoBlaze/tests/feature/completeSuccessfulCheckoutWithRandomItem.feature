Feature: Login


  Scenario Outline: Adding random item to the cart and checking out it
    Given user will click on login button
    And user will enter "<username>" and "<password>" and click on login button
    Then validate on the "<username>" is shown as the logged in user
    When random item is selected
    And click on add to cart button
    Then alert will appear with message "<Message>" that item is added successfully
    When clicking on cart button in the home page
    And clicking on place order button
    And fill the place order form by entering "<Name>" , "<Country>" , "<City>" , "<CreditCard>" , "<Month>" and "<Year>"
    Then Click ok button
    Examples:
      |username     | password     |Message       |Name |Country|City |CreditCard     |Month|Year|
      |testsss112236| testsss112236|Product added.|Ahmed|Egypt  |Cairo|912836172637123|12   |24  |