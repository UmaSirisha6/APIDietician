@UserGet
Feature: Checking Get Https request in User API

Background: Authorization is set to Basic Auth 
   Given User creates GET Method 
  
@GetAllUser
Scenario: To get all the Users available
  
  When User calls "GetUserApi" Https Request with "Get" from sheet "GetUser"
  Then User receive HTTP "Status code" and response body
  
  
Scenario: To get all the Users available with valid contact info
  
  When User calls "GetUserByContact" Https Request with "GetByContact" from sheet "GetUser"
  Then User receive HTTP "Status code" and response body
 
Scenario: To get all the Users available with valid Email
  
  When User calls "GetUserByEmail" Https Request with "GetByEmail" from sheet "GetUser"
  Then User receive HTTP "Status code" and response body
 
Scenario: To get all the Users available with valid User Type
  
  When User calls "GetUserByUserType" Https Request with "GetByUserType" from sheet "GetUser"
  Then User receive HTTP "Status code" and response body
   
 Scenario: To get all the Users available with valid Dietician Id
  
  When User calls "GetUserByDieticianID" Https Request with "GetByDieticianID" from sheet "GetUser"
  Then User receive HTTP "Status code" and response body
 
Scenario: To get all the Users available with invalid contact info
  
  When User calls "GetUserByContact" Https Request with "GetByContact" from sheet "GetUser"
  Then User receive HTTP "Status code" and response body
 
Scenario: To get all the Users available with invalid Email
  
  When User calls "GetUserByEmail" Https Request with "GetByEmail" from sheet "GetUser"
  Then User receive HTTP "Status code" and response body
 
Scenario: To get all the Users available with invalid User Type
  
  When User calls "GetUserByUserType" Https Request with "GetByUserType" from sheet "GetUser"
  Then User receive HTTP "Status code" and response body
   
Scenario: To get all the Users available with invalid Dietician Id
  
  When User calls "GetUserByDieticianID" Https Request with "GetByDieticianID" from sheet "GetUser"
  Then User receive HTTP "Status code" and response body
 

  