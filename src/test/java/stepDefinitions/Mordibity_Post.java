package stepDefinitions;


import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;
import resources.PayLoad;

import utility.ExcelUtil;


public class Mordibity_Post  extends Base{
	
	static String Morbidity;
	static String postRequestBody;
	static String actualMorbidity;
	static String actualMorbidityTestID;
	static String ExpectedTestId;
	int actualStatusCode;
	static String StatusCode;
	int statusCode;
	static String Expectedmessage;
	static Map<String, String> xl;

@Given("User creates Post method Endpoint data from {string} and {int}")
public void user_creates_post_method_endpoint_data_from_and(String sheetName, Integer RowNumber) throws IOException {
  
	xl = ExcelUtil.getxlData(sheetName).get(RowNumber);

	StatusCode = xl.get("Status");
	Expectedmessage = xl.get("Message");
	postRequestBody = PayLoad.Payload(xl);

	requestSpecBuilder = given().spec(requestSpecification()).body(postRequestBody);

	assertThat(postRequestBody, matchesJsonSchemaInClasspath(getGlobalValue("MorbidityPutReqSchema")));

	}


	@When("User calls {string} https Request with {string}")
	public void user_calls_https_request_with_from_sheet(String resource, String method) throws IOException 
	
	{
		response = requestSpecBuilder.when().post(resource(resource));
	}


	@Then("User receive HTTP {string} response body and verify test_Id created using {string} in {string} request")
	public void user_receive_http_response_body_and_verify_test_id_created_using_in_request(String resource, String method, String sheetName) throws  IOException 
	{

		Morbidity = getJsonPath(response, "Message");
		actualMorbidityTestID = response.jsonPath().getString("MorbidityTestId");
		ExpectedTestId = xl.get("Morbidity Test ID");

		assertEquals(ExpectedTestId, actualMorbidityTestID);
		assertEquals(Expectedmessage, Morbidity);
		assertEquals(Integer.parseInt(StatusCode), response.getStatusCode());

	}
	
	@Then("User receive HTTP {string} response body")
	public void user_receive_http_response_body(String string) throws IOException
	{
		Morbidity       = getJsonPath(response,"Message");
		actualMorbidity = Morbidity.replace("/[]/" , " ");
		
		assertEquals(Expectedmessage,actualMorbidity);
		assertEquals(Integer.parseInt(StatusCode),response.getStatusCode());
		response.then().assertThat().body(matchesJsonSchemaInClasspath(getGlobalValue("MorbidityPostResSchema")));
	}

	
}
