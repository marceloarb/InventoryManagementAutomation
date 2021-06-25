Feature:
  Homepage load with all products

  @SeleniumTest
  Scenario: Validate products in homepage
    Given any scenario
    When homepage is loaded
    Then all products all displayed