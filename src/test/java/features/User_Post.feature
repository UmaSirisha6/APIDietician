@UserPOST
Feature: Creating User Details

  Background: Authorization set to "Basic Auth"
    Given User creates POST Method EndPoint
    
@UserPOSTApi
  Scenario: Check if user able to create record 
    When User calls "UserPostApi"  Http request with "POST" from sheet "UserApiPOST"
    Then User receive HTTP "Status code" and response body

 
 