#Author: Kenneth
Feature: Google Search Function

  Scenario Outline: As a SEO Analyst,I want to be able to search google.co.uk using the Google Chrome browser with any given search term
    so that i can determine if a given website is in the first page of the search results

    Given I am on the google.co.uk search page using chrome browser
    And I search for the searchterm "<searchterm>" in the search box field
    Then I verify and report that the expected site "<expectedsite>" is on the first page of results
    Then I close my browser

    # Parameters for the test are contained in the Example table
    Examples: 
      | searchterm | expectedsite                               |
      | insurance  | http://www.moneysupermarket.com/insurance/ |
