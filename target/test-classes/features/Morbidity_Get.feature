@GetMorbidity
Feature: Checking Get Https Request in Morbidity

Background: Authorization is set to Basic Auth 
	Given User creates GET Method Endpoint 
	
	@GetMorbidityApi
	Scenario: Check GetMorbidity Http request
	
    When User calls "GetMorbidity" Https Request with "GET" from sheet "GETMorbidity"
    Then User receive HTTP Status code and success message
    
   	@GetMorbiditybyName
    Scenario: Check if we are getting record of a particular MorbidityName
	When User calls "GetMorbiditybyName" Https Request with "GETByName" from sheet "GETMorbidity"
	Then User receive HTTP Status code and success message
	
	@GetMorbiditybyId
    Scenario: Check if we are getting record of a particular MorbidityTestId 
	When User calls "GetMorbiditybyTestid" Https Request with "GETByID" from sheet "GETMorbidity"
	Then User receive HTTP Status code and success message 
	

	
