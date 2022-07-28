package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Base;
import utility.ExcelUtil;
public class AuthorizationStepDef extends Base {
	
	RequestSpecification request;
	Response response;
	private Map<String, String> xl;
	@Given("User create a http request")
	public void user_create_a_http_request() throws IOException 
	{
	    request = given().baseUri(getGlobalValue("baseURI"));
	}

	@When("User calls {string} request in no auth")
	public void user_calls_request_in_no_auth(String resource)
	{
	    response =request.when().get(resource(resource));
	}

	@Then("user should receive error code")
	public void user_should_receive_error_code() throws NumberFormatException, IOException 
	{
            assertEquals( Integer.parseInt(getGlobalValue("UnAuthorized")),response.getStatusCode());
	}
	
	@Given("User create a http request with basic auth")
	public void user_create_a_http_request_with_basic_auth() throws IOException 
	{
		request = given().baseUri(getGlobalValue("baseURI")).auth().basic(getGlobalValue("Username"), getGlobalValue("Password"));
	}

	@When("User calls {string} http request with basic auth")
	public void user_calls_http_request_with_basic_auth(String resource) throws NumberFormatException, IOException 
	{
		 response =request.when().get(resource(resource));

	}

	@Then("user should receive success code")
	public void user_should_receive_success_code() throws NumberFormatException, IOException 
	{
		
		 assertEquals( Integer.parseInt(getGlobalValue("StatusCode")),response.getStatusCode());
	}

	@Given("User create a http request with invalid details")
	public void user_create_a_http_request_with_invalid_details() throws IOException 
	{
		request = given().baseUri(getGlobalValue("baseURI")).auth().basic(getGlobalValue("wrongusername"), getGlobalValue("Wrongpassword"));
	}
	@When("User call {string} http request with invalid username")
	public void user_call_http_request_with_invalid_username(String resource) throws NumberFormatException, IOException 
	{
           response =request.when().get(resource(resource));

	}

	@Then("user should receive unauthorized message")
	public void user_should_receive_unauthorized_message() throws NumberFormatException, IOException 
	{
		
        assertEquals( Integer.parseInt(getGlobalValue("ErrorCode")),response.getStatusCode());

	}

	@When("User call {string} http request with invalid Password")
	public void user_call_http_request_with_invalid_password(String resource)
	{
             response =request.when().get(resource(resource));
	}


	@When("User calls http request with different methods {string} {int}")
	public void user_calls_http_request_with_different_methods(String sheetName, Integer RowNumber)
	{
		xl = ExcelUtil.getxlData(sheetName).get(RowNumber);
		String method = xl.get("Method");
		String resource = xl.get("Resource");
		
	switch(method) {
	case "Post": response =request.when().post(resource(resource));
	break;
	case "Put" : response =request.when().get(resource(resource));
	break;
	case "Delete" : response =request.when().get(resource(resource));
	break;
	case "GetRecipe" : response =request.when().get(resource(resource));
	break;
	}
	}

}
