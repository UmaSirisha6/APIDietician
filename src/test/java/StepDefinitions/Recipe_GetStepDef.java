package StepDefinitions;

import io.cucumber.java.en.*;
import resources.Base;
import static io.restassured.RestAssured.*;
public class Recipe_GetStepDef extends Base {
	
	
	@Given("User creates GET Method Endpoint")
	public void user_creates_get_method_endpoint() {
	   given().spec(requestSpecification)
	}

	@When("User calls {string} http request with {string}")
	public void user_calls_http_request_with(String string, String string2) {
	    
	}
	
	@When("User calls {string} http request with {string} from sheet {string}")
	public void user_calls_http_request_with_from_sheet(String string, String string2, String string3) {
	   
	}
	
	
	@Then("User receive HTTP {string} and response body")
	public void user_receive_http_and_response_body(String string) {
	   
	}

	

}
