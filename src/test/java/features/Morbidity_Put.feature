

Feature: Update Morbodity Details in Morbodity Api
Background: Authorization is set to "Basic Auth" 
		Given User creates PUT Method EndPoint

	Scenario: check morbidity put request   

    When User calls "PUTmorbidity" http request with "PUT" from sheet "PUTMorbidity"
    Then User receive  HTTP "Status code" and response body
    
    
    


    

    
    
   
 
   

  
