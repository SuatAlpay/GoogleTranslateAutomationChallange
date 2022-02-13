Feature:
  Testing Google Translate website to compare results from selected source languages and translation languages


  Background:
    Given User is on Google Translate website
    When User select source language from the drop-down menu on the left as German
    And Users select translation language from the drop-down menu on the right as Spanish
    And User enters the initial text in the input field on the left

  Scenario:
    Then The initial text should match the translated text

  Scenario:
    And User clicks swap languages button
    Then The source language text should match translated text

  Scenario:

    And User clears the input field
    And User clicks select input tool button
    And User selects screen keyboard
    Then User should enter Hi