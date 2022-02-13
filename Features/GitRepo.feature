Feature: Git Repo

@sanity
Scenario Outline: Verify Git repo names and description
	Given User Launch Chrome browser 
	When User opens URL "<repoURL>" 
	And Move to Repositories section
	And get all Repo titles and desc from API using "<APIUrl>" 
 	And get all Repo titles and desc from UI
	Then Verify Actual data of UI with Expected data from API
	Then close browser

	
Examples: 
		| repoURL | APIUrl |
		| https://github.com/django	| https://api.github.com/orgs/django/repos |