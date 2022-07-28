@Authorization
Feature: Checking Basic Authorization



@SanityTest
@Smoketest
@InNoAuth 
Scenario: Checking API Authorization
Given User create a http request 
When User calls "GetMorbidity" request in no auth 
Then user should receive error code

@SmokeTest
Scenario: Checking API Authorization
Given User create a http request with basic auth
When User calls "GetMorbidity" http request with basic auth 
Then user should receive success code


@SmokeTest
Scenario: Checking API Authorization with Invalid details
Given User create a http request with invalid details
When User call "GetRecipe" http request with invalid username
Then user should receive unauthorized message

@SmokeTest
Scenario: Checking API Authorization with Invalid details
Given User create a http request with invalid details
When User call "GetRecipe" http request with invalid Password
Then user should receive unauthorized message

@SmokeTest
Scenario Outline: Checking API Authorization with basic auth
Given User create a http request with basic auth
When User calls http request with different methods "<sheetName>" <RowNumber>
Then user should receive unauthorized message

Examples:
| sheetName    | RowNumber|
|Authorization |   0      |
|Authorization |   1      |
|Authorization |   2      |

