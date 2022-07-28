@MorbidityDelete
Feature: Delete Record in Morbidity API
Background: Authorization is set to Basic Auth 
   Given User creates DELETE Method 
  

@MorbidityDeleteUser
@SanityTest
Scenario Outline: Morbidity Delete http request  
  
  When User calls "DeleteMorbidity" "DeleteMorbiditybyTestId" with "Delete"  http request from  "<sheetName>" <RowNumber>
 Then User receive HTTP Status code and Verify by calling "GetMorbidity" with "Get" 
  

  Examples:
	|sheetName    	 | RowNumber  |
	|DELETEMorbidity | 0          |
	|DELETEMorbidity | 1          |
	
	
 @MorbidityDELETEwithoutMorbidityName  
 @SmokeTest
Scenario Outline: Morbidity Delete without MorbidityName
  
 When  User calls "DeleteMorbidity" "DeleteMorbiditybyTestId" with "Delete"  http request from  "<sheetName>" <RowNumber>
 Then User receive HTTP Status code and Verify by calling "GetMorbidity" with "Get"
 
   Examples:
	|sheetName    	 | RowNumber  |
	|DELETEMorbidity | 4          |
	
	
 @MorbidityDELETEwithoutMorbidityTEST_ID 
 @RegressionTest
Scenario Outline: Morbidity Delete without Test_ID

 When User calls "DeleteMorbidity" "DeleteMorbiditybyTestId" with "Delete"  http request from  "<sheetName>" <RowNumber>
 Then User receive HTTP "Status code" and JsonResponse body
 
  Examples:
	|sheetName    	 | RowNumber  |
	|DELETEMorbidity | 2          |
 
  @MorbidityDELETEwithoutMorbidityTEST_ID 
  @RegressionTest
Scenario Outline: Morbidity Delete with Non-existing Test_ID 
  
 When  User calls "DeleteMorbidity" "DeleteMorbiditybyTestId" with "Delete"  http request from  "<sheetName>" <RowNumber>
 Then User receive HTTP "Status code" and JsonResponse body
 
 
  Examples:
	|sheetName    	 | RowNumber  |
	|DELETEMorbidity | 5          |


@MorbidityDeletewithNon-exisitingMorbidityName
@RegressionTest	
Scenario Outline: Morbidity Delete with Non-existing MorbidityName

 When  User calls "DeleteMorbidity" "DeleteMorbiditybyTestId" with "Delete"  http request from  "<sheetName>" <RowNumber>
 Then User receive HTTP "Status code" and JsonResponse body
 
  Examples:
	|sheetName    	 | RowNumber  |
	|DELETEMorbidity | 6          |
 