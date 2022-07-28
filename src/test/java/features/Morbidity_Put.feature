@PuTMorbidity
Feature: Update Morbodity Details in Morbodity Api
Background: Authorization is set to Basic Auth 

@SanityTest	 
	Scenario Outline:  morbidity Api PUT request with morbidity data
	 Given User creates morbidity PUT Method EndPoint from "<SheetName>" and "<RowNumber>"
    When User calls put morbidity "MorbidityAPI" Https Request with "PUT"
    Then User receive  morbidity PUT request sucess "200" and response body
  
  Examples:
	| SheetName    	  | RowNumber    |
	| PUTMorbidity    | 0            |
	| PUTMorbidity    | 1            |	

   
   @SmokeTest
  Scenario Outline: morbidity Api PUT request with invalid morbidity name
  	Given User creates morbidity PUT Method EndPoint from "<SheetName>" and "<RowNumber>"
  	When User calls put morbidity "MorbidityAPI" Https Request with "PUT"
  	Then User receive morbidity PUT request failed "404" and error message
  
  Examples:
    |SheetName    	  | RowNumber    |
	| PUTMorbidity    | 2            |
	| PUTMorbidity    | 3            |	

 @RegressionTest
 Scenario Outline: morbidity Api PUT request with invalid morbidity testid
  Given User creates morbidity PUT Method EndPoint from "<SheetName>" and "<RowNumber>"
  	When User calls put morbidity "MorbidityAPI" Https Request with "PUT"
  	Then User receive morbidity PUT request failed "404" and error message
  
  Examples:
  |SheetName    	  | RowNumber    |
	| PUTMorbidity    | 4            |
	| PUTMorbidity    | 5            |	
	
	@RegressionTest
  Scenario Outline: morbidity Api PUT request with missing morbidity testunit in request body
   Given User creates morbidity PUT Method EndPoint from "<SheetName>" and "<RowNumber>"
  	When User calls put morbidity "MorbidityAPI" Https Request with "PUT"
  	Then User receive morbidity PUT request failed "400" and error message
  
  Examples:
  |SheetName    	  | RowNumber    |
  | PUTMorbidity      | 6		     |
  
  @RegressionTest	
 Scenario Outline: morbidity Api PUT request with missing morbidity markerref in request body
  Given User creates morbidity PUT Method EndPoint from "<SheetName>" and "<RowNumber>"
  	When User calls put morbidity "MorbidityAPI" Https Request with "PUT"
  	Then User receive morbidity PUT request failed "400" and error message
  
  Examples:
  |SheetName    	  | RowNumber    |
  | PUTMorbidity      | 7			 |
  
  @RegressionTest	
  Scenario Outline: morbidity Api PUT request with missing endpoint params
  Given User creates morbidity PUT Method EndPoint from "<SheetName>" and "<RowNumber>"
  	When User calls put morbidity "MorbidityAPI" Https Request with "PUT"
  	Then User receive morbidity PUT request failed "405" and error message
  
  Examples:
  |SheetName        | RowNumber    |
  | PUTMorbidity    | 8			   |
  | PUTMorbidity    | 9 		   |
  	
 
  	
  	  
    


    

    
    
   
 
   

  
