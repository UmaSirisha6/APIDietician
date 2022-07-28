Feature: Creating User Details 

 


	
 @BatchMorbidityPostRequest 
 @RegressionTest
Scenario: Check if user able to send Batch of record 
	Given User creates POSTMethod EndPoint  from sheet "BatchPostMorbidity1"
	When User calls "PostMorbidity" request with "PostbatchRequest"
	Then User receive http statusCode and response body 
	
	
	
	
 @BatchMorbidityPostRequest 
 @RegressionTest
Scenario: Check if user able to send Batch of record 
	Given User creates POSTMethod EndPoint  from sheet "BatchPostMorbidity" 
	When User calls "PostMorbidity" request with "PostbatchRequest"
	Then User receive http statusCode and response body 
		