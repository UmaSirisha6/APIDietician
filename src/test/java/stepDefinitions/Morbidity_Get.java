package stepDefinitions;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import resources.Base;
import utility.ExcelUtil;

public class Morbidity_Get extends Base {

	private Map<String, String> xl;
	private String expectedMorbidityID;
	private String expectedMorbidityName;
	private String method;
	public static String expectedmessage;
	int Status;
	int responseLength;
	public ExtentTest logger;
	public static String actualMessage;
	public static String actualErrorMessage;
	JsonPath jsonPathEvaluator;


	@Given("User creates GET Method Endpoint")
	public void user_creates_get_method_endpoint() throws IOException
   {
		requestSpecBuilder = given().spec(requestSpecification());
	}

	
	@When("User calls {string} with {string} Https Request")
	public void user_calls_with_https_request(String resource, String method) 
	{
			response = requestSpecBuilder.when().get(resource(resource));
	}
	

	@Then("User receive HTTP Status code")
	public void user_receive_http_status_code() throws NumberFormatException, IOException 
	{
		responseSpecBuilder = requestSpecBuilder.then().spec(responseSpecification()).body(matchesJsonSchemaInClasspath(getGlobalValue("MorbidityGetResSchema")));
	}
	
	
	@When("User calls {string} Https Request with {string} from {string} and {int}")
	public void user_calls_https_request_with_from_and (String resource, String method, String sheetName, Integer RowNumber) throws NumberFormatException
	{
			
		xl = ExcelUtil.getxlData(sheetName).get(RowNumber);
		expectedMorbidityName = xl.get("MorbidityName");
		expectedMorbidityID = xl.get("MorbidityID");
		expectedmessage = xl.get("Message");
   		
        switch (method) {
		case "GETByName":
				response = requestSpecBuilder.when().get((resource(resource) + expectedMorbidityName));
		break;
		case"GETByID":
			response = requestSpecBuilder.when().get((resource(resource) + expectedMorbidityID));
		break;
        }
	}
	
	@When("User calls {string} Https Request from {string} and {int}")
	public void user_calls_https_request_from_and(String resource, String sheetName, Integer RowNumber) 
	{
		xl = ExcelUtil.getxlData(sheetName).get(RowNumber);
		expectedMorbidityName = xl.get("MorbidityName");
		expectedMorbidityID = xl.get("MorbidityID");
		expectedmessage = xl.get("Message");
		this.method = xl.get("MethodByName");
		
		
		switch(this.method) {
		case "Post":
			response = requestSpecBuilder.when().post((resource(resource)+ expectedMorbidityName));break;
		case "Put":
			response = requestSpecBuilder.when().put((resource(resource) + expectedMorbidityID));break;
		case "Delete":
      		response = requestSpecBuilder.when().delete((resource(resource)+ expectedMorbidityID));break;
  		}
	
	}
	
	@Then("User receive HTTP Status code and response body with MorbidityID")
	public void user_receive_http_status_code_and_response_body_with_morbidity_id() throws IOException
	{
	
	   	if(Integer.parseInt(xl.get("StatusCode")) == Integer.parseInt(getGlobalValue("StatusCode")))
	       	responseSpecBuilder =	requestSpecBuilder.then().body(containsString(expectedMorbidityID)).body(matchesJsonSchemaInClasspath("./jsonSchema/GetMorbiditySchema.json"));
		else 
		{
		    assertEquals(Integer.parseInt(xl.get("StatusCode")), response.getStatusCode()); 
		} 
		 
	}
	
	@Then("User receive HTTP Status code and response body with MorbidityName")
	public void user_receive_http_status_code_and_response_body_with_morbidity_name() throws IOException {
			
		
		actualErrorMessage = response.jsonPath().getString("message");

		if (Integer.parseInt(xl.get("StatusCode")) == Integer.parseInt(getGlobalValue("StatusCode"))) {
			responseSpecBuilder = requestSpecBuilder.then().spec(responseSpecification())
								  .body(containsString(expectedMorbidityName)).and()
								  .body(matchesJsonSchemaInClasspath(getGlobalValue("MorbidityGetResSchema")));
		}

		else if (Integer.parseInt(xl.get("StatusCode")) == Integer.parseInt(getGlobalValue("ErrorCode"))) 
		{
               assertEquals(Integer.parseInt(xl.get("StatusCode")), response.getStatusCode());
		} else 
		{
			assertEquals(Integer.parseInt(xl.get("StatusCode")), response.getStatusCode());
			
		}
		
	}	

}
