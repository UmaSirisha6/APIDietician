package stepDefinitions;
import static io.restassured.RestAssured.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class GETRecipeSteps {
	
	
@Given("User creates GET Method Endpoint")
public void user_creates_get_method_endpoint() {
	RestAssured.baseURI = "http://localhost:8780/api/";
	given().auth().basic("Username","Password ");
	
    
}

@When("User calls {string} http request with {string}")
public void user_calls_http_request_with(String string, String string2) {
	when().get("Recipes");
   
}

@Then("User receive HTTP {string} and response body")
	public void user_receive_http_and_response_body(String string) {
	
	  
	}

}
