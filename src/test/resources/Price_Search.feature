Feature: Price search on zoopla
  @price
  Scenario:

    Given user enters the search as "London"
    Given user selects max price
    When user clicks on advanced search options
    Then user chooses only the new homes and clicks on search to see the list of houses
    And gets the houses price list
    Then user should see the contact details of the agent
