Feature: This file contains product related test cases

Scenario: Verify search result for polo men

	Given chrome browser is open
	And url is launched
	When user searches for polo t shirt
	Then all results should be realted to polo
	