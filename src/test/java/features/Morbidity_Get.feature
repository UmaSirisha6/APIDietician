@GetMorbidityAPI
Feature: Checking Get Https Request in Morbidity

Background: Authorization is set to Basic Auth 
	Given User creates GET Method Endpoint 
	
	@GetAllMorbidity
	Scenario: GET HTTP REQUEST 
	When User calls "GetMorbidity" with "GET" Https Request 
    Then User receive HTTP Status code 
     
     @MorbidityName	
    Scenario Outline: Check if we are getting record of a particular MorbidityName
	When User calls "GetMorbiditybyName" Https Request with "GETByName" from "<sheetName>" and <RowNumber>
	Then User receive HTTP Status code and response body with MorbidityName 
	
	Examples:
	|sheetName    	| RowNumber  |
	|GETMorbidity   | 0          |
	
	# Wrong ENDPOINT
	@MorbidityNameWithWrondEndpoint
	Scenario Outline: Check MorbidityName with Wrong Endpoint
	When User calls "GetMorbidityName" Https Request with "GETByName" from "<sheetName>" and <RowNumber>
	Then User receive HTTP Status code and response body with MorbidityName
	
	Examples:
	|sheetName    	| RowNumber  |
	|GETMorbidity   | 1          |
	
	#Invalid Details 
	@MorbidityNamewithInvalidDetails
	Scenario Outline: Check if we are getting record of a particular MorbidityName with invalid details
	When User calls "GetMorbiditybyName" Https Request with "GETByName" from "<sheetName>" and <RowNumber>
	Then User receive HTTP Status code and response body with MorbidityName 
	
	Examples:
	|sheetName    	| RowNumber  |
	|GETMorbidity   | 1          |
	|GETMorbidity   | 2          |
	|GETMorbidity   | 3          |
	|GETMorbidity   | 4          |
	|GETMorbidity   | 5          |
	|GETMorbidity   | 6          |
	
	#Different reqest
	@MorbidityNamewithDifferentMethods
	Scenario Outline: Check MorbidityName API With different requests
	When User calls "GetMorbiditybyName" Https Request from "<sheetName>" and <RowNumber>
	Then User receive HTTP Status code and response body with MorbidityName 
	
	Examples:
	|sheetName    	| RowNumber  |
	|GETMorbidity   | 7          |
	|GETMorbidity   | 8          |
	|GETMorbidity   | 9          |
	
	#MorbidityTestId
	@GetMorbidityTestID
    Scenario Outline: Check MorbidityTestId with valid id and endpoint
	When User calls "GetMorbiditybyTestid" Https Request with "GETByID" from "<sheetName>" and <RowNumber>
	Then User receive HTTP Status code and response body with MorbidityID
	
	Examples:
	|sheetName    	| RowNumber  |
	|GETMorbidity   | 0          |
	
	#MorbidityWrong Endpoint
	@GetMorbidityByTestIdWithwrongEndpoint
	Scenario Outline: Check  MorbidityTestId with valid id and wrong endpoint
	When User calls "GetMorbidityTestid" Https Request with "GETByID" from "<sheetName>" and <RowNumber>
	Then  User receive HTTP Status code and response body with MorbidityID
	
	Examples:
	|sheetName    	| RowNumber  |
	|GETMorbidity   | 1          |
	
		#Invalid Details 
	@MorbidityBytestIdwithInvaliddetails
	Scenario Outline: Check MorbidityId with invalid details
	When User calls "GetMorbiditybyTestid" Https Request with "GETByID" from "<sheetName>" and <RowNumber>
	Then User receive HTTP Status code and response body with MorbidityID
	
	Examples:
	|sheetName    	| RowNumber  |
	|GETMorbidity   | 1          |
	|GETMorbidity   | 2          |
	|GETMorbidity   | 3          |
	|GETMorbidity   | 4          |
	|GETMorbidity   | 5          |
	|GETMorbidity   | 6          |
	
	#WithDifferentRequest
	@MorbidityByIdwithdifferentRequest
	Scenario Outline: Check MorbidityId with different endpoints
	When User calls "GetMorbiditybyTestid" Https Request from "<sheetName>" and <RowNumber>
	Then User receive HTTP Status code and response body with MorbidityID
	Examples:
	|sheetName    	| RowNumber  |
	|GETMorbidity   | 7          |
	|GETMorbidity   | 8          |
	|GETMorbidity   | 9          |
	
	
	
	

	
	

