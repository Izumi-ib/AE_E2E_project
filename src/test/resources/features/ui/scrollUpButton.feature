@ui @regression @scroll
Feature: User scrolls up and down with arrow button and without
  Background:
    Given user clicks consent button verifies home page is visible

  Scenario: User scrolls down manually and goes up by using Arrow
    When user scrolls down to footer
    Then user verifies 'SUBSCRIPTION' title
    When user clicks Upward Arrow button
    Then user verifies that the top title in the Home page 'Full-Fledged' is displayed

  Scenario: User scrolls down manually and goes up manually
    When user scrolls down to footer
    Then user verifies 'SUBSCRIPTION' title
    When user scrolls up to Page top
    Then user verifies that the top title in the Home page 'Full-Fledged' is displayed