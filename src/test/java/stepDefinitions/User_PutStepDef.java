package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import resources.APIResources;
import resources.Base;

public class User_PutStepDef extends Base{

	//RequestSpecification req;
	//ResponseSpecification res;
	APIResources resourceapi;
	Response response; 
	
@Given("User creates PUT Method EndPoint")
public void user_creates_put_method_end_point() throws IOException {
   
	req = given().spec(requestSpecification()).pathParam("DieticianID", "DT001").pathParam("UserID","UT0001").body(""); //absuri
			// from excel sheet i will get path parameters 
	      // we have to give sheet name in this method 
}

@When("User calls {string} Https Request with {string} from Sheet {string}")
public void user_calls_https_request_with_from_sheet(String resource, String method, String sheetname) {
     
	resourceapi = APIResources.valueOf(resource);
	System.out.println(resourceapi.getResource());
	response = req.when().put((resourceapi.getResource()+ "{DieticianID}" + "{UserID}")); //c
}

@Then("User receive HTTP {string} and response body")
public void user_receive_http_and_response_body(String string) {
    
	assertEquals(response.getStatusCode(),200);
	
	
}
}
