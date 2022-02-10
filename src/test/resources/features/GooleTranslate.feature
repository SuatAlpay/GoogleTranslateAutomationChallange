Feature:
  Testing Google Translate website to compare results


  Background:
    Given User is on Google Translate website

  Scenario:
    When User select source language from the drop-down menu on the left as "German"
    And Users select translation language from the drop-down menu on the right as "Spanish"
    And User enters the initial text in the input field on the left
    Then The initial text should match the translated text

  Scenario:
    When User select source language from the drop-down menu on the left as "German"
    And Users select translation language from the drop-down menu on the right as "Spanish"
    And User clicks swap languages button
    Then The source language text should match translated text

  Scenario:
    When User select source language from the drop-down menu on the left as "German"
    And Users select translation language from the drop-down menu on the right as "Spanish"
    And User clears the input field
    And User clicks select input tool button
    And User selects screen keyboard
    Then User should enter "Hi"