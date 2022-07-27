package stepDefinitions;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;
import resources.DieticianResources;
import resources.PayLoad;
import utility.ExcelUtil;

public class User_PostStepDef extends Base {

	ExcelUtil xlutil;
	DieticianResources resourceAPI;
	Map<String, String> xl;
    static String userPostReqBody;
	int Status;

	@Given("User creates POST Method EndPoint  with data from {string} and {int}")
	public void user_creates_post_method_end_point_with_data_from_and(String sheetName, Integer RowNumber) throws IOException {
	
		xl = ExcelUtil.getxlData(sheetName).get(RowNumber);
		userPostReqBody = PayLoad.userpostPayLoad(xl);
		requestSpecBuilder = given().spec(requestSpecification()).body(userPostReqBody);
	}


	@When("User calls {string} Https Request with {string}")
	public void user_calls_http_request_with(String resource, String method) 
	{
		response = requestSpecBuilder.when().post(resource(resource));
	}

	@Then("User receive HTTP {string} and response body")
	public void user_receive_http_and_response_body(String StatusCode) throws NumberFormatException, IOException {
		Status = Integer.valueOf(xl.get("ExpectedStatusCode"));
		if(Status==200)
		{
			response.then().assertThat().body(matchesJsonSchemaInClasspath(getGlobalValue("UserPostResSchema")));
		}
			
		responseSpecBuilder = requestSpecBuilder.then().spec(responseSpecification()).body("message",Matchers.equalTo(xl.get("Message")));
		assertEquals(response.getStatusCode(),Status);


	}

}
