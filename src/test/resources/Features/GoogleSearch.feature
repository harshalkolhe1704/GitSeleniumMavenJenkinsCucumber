Feature: Google Search
	As a user
	I want to be able to search on Google 
	So that I can find relevant information

  Scenario:
    Given I am on the search page
    When I search for a keyword
    Then I should see search results for keyword
