@Morbidity
Feature: Creating User Details 
Background: Authorization set to  Basic Auth


   @POstMorbitySinglePayload
   @RegressionTest
   Scenario Outline: PostMorbidity with valid details 
   
	Given User creates Post method Endpoint data from "<sheetName>" and <RowNumber>
	When User calls "PostMorbidity" https Request with "POST"
	Then User receive HTTP "PostMorbidity" response body and verify test_Id created using "GetMorbidity" in "Get" request 
	
	Examples:
	|sheetName    	| RowNumber  |
	| POSTMorbidity | 0          |
	| POSTMorbidity | 1          |
	
	@PostMorbidityInvalidPayload
	@RegressionTest
   Scenario Outline: PostMorbidity with invalid details 
   
	Given User creates Post method Endpoint data from "<sheetName>" and <RowNumber>
	When User calls "PostMorbidity" https Request with "POST"
	Then User receive HTTP "PostMorbidity" response body
	
	Examples:
	|sheetName      | RowNumber  |
	| POSTMorbidity |  2         |
	| POSTMorbidity |  3         |
	| POSTMorbidity |  4         |
	| POSTMorbidity |  5         |
	| POSTMorbidity |  6         |
	| POSTMorbidity |  7         |
	| POSTMorbidity |  8         |
	| POSTMorbidity |  9         |
	| POSTMorbidity |  10        |
	| POSTMorbidity |  11        |
	| POSTMorbidity |  12        |
	
	
	