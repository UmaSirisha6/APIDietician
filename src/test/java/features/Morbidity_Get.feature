@GetMorbidity
Feature: Checking Get Https Request in Morbidity

Background: Authorization is set to Basic Auth 
	Given User creates GET Method Endpoint 
	
	@GetMorbidityApi
	Scenario: Check GetMorbidity Http request
	
    When User calls "GetMorbidity" Https Request with "GET"
    Then User receive HTTP "Status code" and response body from sheet "StatusCode"
    
   	@GetMorbiditybyName
    Scenario: Check if we are getting record of a particular MorbidityName
	When User calls "GetMorbiditybyName" Https Request with "GET"
	Then User receive HTTP "Status code" and response body from sheet "StatusCode"
	
	@GetMorbiditybyId
    Scenario: Check if we are getting record of a particular MorbidityTestId 
	When User calls "GetMorbiditybyTestid" Https Request with "GET"
	Then  User receive HTTP "Status code" and response body from sheet "StatusCode" 
	

	
	

