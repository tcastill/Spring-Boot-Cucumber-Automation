Feature: Rhyme Zone Tests

  @Smoke @UI
  Scenario: Rhyme Zone UI Test
    Given user is able to validate the page visibly as correct
    And user is successfully able to enter a text "best" in the input textbox
    Then all the links on the page directs correctly

  @Regression @API
  Scenario: Rhyme Zone API Test
    Given sounds like api returns a 200 for word "best"
    Then check that one of the words is "peste"

