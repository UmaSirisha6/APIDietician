@MorbidityPost
Feature: Creating User Details

  Background: Authorization set to "Basic Auth"
    Given User creates POST Method EndPoint

@MorbidityPostRequest
  Scenario: Check if user able to create record 
    When User calls "UserPostApi" Https Request with "POST" from sheet "MorbidityPost"
    Then User receive HTTP "Status code" response body and verify test_Id created to using "GetMorbidity"

	
