package stepDefinitions;
import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;

public class GETRecipeSteps extends Base {

	public static RequestSpecification req;
	public static ResponseSpecification res;
	
	
@Given("User creates GET Method Endpoint")
public void user_creates_get_method_endpoint() {
	 req=given().spec(requestSpecification);
	
    
}

@When("User calls {string} http request with {string}")
public void user_calls_http_request_with(String resource, String method) {
	APIResources resourceAPI= APIResources.valueOf(resource);
   
}

@Then("User receive HTTP {string} and response body")
	public void user_receive_http_and_response_body(String string) {
	
	  
	}

}
