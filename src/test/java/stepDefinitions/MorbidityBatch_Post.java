package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import resources.Base;
import resources.BatchPayload;



public class MorbidityBatch_Post extends Base {
	
	
	static  String actualMessage;
	static String StatusCode;
    static String expectedmessage;
	static List<Map<String, String>> xl;
	
	@Given("User creates POSTMethod EndPoint  from sheet {string}")
	public void user_creates_post_method_end_point_from_sheet(String sheetName) throws IOException 
	{
	 requestSpecBuilder = given().spec(requestSpecification()).body(BatchPayload.creatingBatchPayload(sheetName)); 
		
				
	}
	
	@When("User calls {string} request with {string}")
	public void user_calls_https_request_with_from_sheet(String resource, String method) throws IOException 
	
	{		
       response = requestSpecBuilder.when().post(resource(resource));
    
	}
	
	@Then("User receive http statusCode and response body")
	public void user_receive_http_status_code_and_response_body() throws IOException {
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		actualMessage = jsonPathEvaluator.getString("message");
		expectedmessage= getGlobalValue("errorMessage");
		StatusCode = getGlobalValue("StatusCode");
		
		assertEquals(expectedmessage,actualMessage);
		assertEquals(Integer.parseInt(StatusCode),response.getStatusCode());
	}


}
