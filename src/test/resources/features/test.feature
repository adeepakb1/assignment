Feature: Assignment

#  Narrative:
#  As a merchant
#  I want to get my existing members

  @Games
  Scenario Outline: As a user I want to search weather from NDTV website and validate
    Given The User opens to ndtv page
    And User waits and clicks on "<text-name1>"
    And User clicks on triple-dot to expand
    And User clicks on "<text-name>"
    When User lands on weather page
    And User search my "<city>"
    Then User sees the result "<city>" on screen
    When User clicks on the selected "<city>"
    Then Weather information is shown
    And I search the "<city>"
    Then The information from two sources are compared

    Examples:
      | text-name | text-name1 |city|
      | WEATHER   | No Thanks  |Patna|




  @Games
  Scenario Outline: As a user
    And I search the "<city>"
    And User waits and clicks on "<text-name1>"

    Examples:
      | text-name | text-name1 |city|
      | WEATHER   | No Thanks  |Patna|
