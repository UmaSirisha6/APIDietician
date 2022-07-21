@MorbidityDelete
Feature: Delete Record in Morbidity API
Background: Authorization is set to Basic Auth 
   Given User creates DELETE Method 
  
@MorbidityDeleteUser
Scenario: Check if User is able to delete record  
  
  When User calls "DeleteMorbidity" Https Request with "Delete" from sheet "DELETEMorbidity"
  Then User receive HTTP "Status code" and response body
   
Scenario: Check if user is able to delete without providing MorbidityName
  
 When User calls "DeleteMorbidity" Https Request with "Delete" from sheet "DELETEMorbidity"
 Then User receive HTTP "Status code" and response body
 
Scenario: Check if user is able to delete without providing Test_ID

 When User calls "DeleteMorbidity" Https Request with "Delete" from sheet "DELETEMorbidity"
 Then User receive HTTP "Status code" and response body
 
Scenario: Check if user is able to delete with Non-existing Test_ID 
  
 When User calls "DeleteMorbidity" Https Request with "Delete" from sheet "DELETEMorbidity"
 Then User receive HTTP "Status code" and response body
 
Scenario: Check if user is able to delete with Non-existing MorbidityName

 When User calls "DeleteMorbidity" Https Request with "Delete" from sheet "DELETEMorbidity"
 Then User receive HTTP "Status code" and response body