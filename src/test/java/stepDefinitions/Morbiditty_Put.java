package stepDefinitions;



import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import resources.Base;
import resources.DieticianResources;
import resources.PayLoad;
import utility.ExcelUtil;
import java.util.Map;


public class Morbiditty_Put extends Base{
	
	DieticianResources resourceAPI;
	Response response;
	ExcelUtil xlutil;
	Map<String, String> xl;
	private String StatusCode;
	String ReqBody;
	String ReqParam;

	@Given("User creates morbidity PUT Method EndPoint from {string} and {string}")
	public void user_creates_morbidity_put_method_end_point_from_and(String sheetname, String rownumber) throws IOException {
		
		xl = ExcelUtil.getxlData(sheetname).get(Integer.parseInt(rownumber));
		ReqBody = PayLoad.creatMorbidityPutBody(xl);
		requestSpecBuilder = given().spec(requestSpecification()).body(ReqBody);
		assertThat(ReqBody, matchesJsonSchemaInClasspath(getGlobalValue("MorbidityPutReqSchema")));
	}

	@When("User calls put morbidity {string} Https Request with {string}")
	public void user_calls_put_morbidity_https_request_with(String resource, String method)
	{
		ReqParam="MorbidityName="+xl.get("ReqParam_MorbidityName")+"&MorbidityTestId="+xl.get("ReqParam_MorbidityTestId");
		response=requestSpecBuilder.when().put(resource(resource) + ReqParam);
	}

	
	@Then("User receive  morbidity PUT request sucess {string} and response body")
	public void user_receive_morbidity_put_request_sucess_and_response_body(String sucesscode) throws IOException {
	
		StatusCode = getGlobalValue("StatusCode");
		assertEquals(Integer.parseInt(StatusCode),response.statusCode());
		assertEquals(xl.get("RepMessage"),response.jsonPath().get("Message"));
		assertEquals(xl.get("RepMorbidityMarkerRef"),response.jsonPath().get("MorbidityMarkerRef"));
		assertEquals(xl.get("MorbidityTestUnit"),response.jsonPath().get("MorbidityTestUnit"));
		//JSON schema validation for response body
		response.then().assertThat().body(matchesJsonSchemaInClasspath(getGlobalValue("MorbidityPutReqSchema")));

	}

	
	@Then("User receive morbidity PUT request failed {string} and error message")
	public void user_receive_morbidity_put_request_failed_and_error_message(String failcode) {
		
		if (failcode.equals("404")){
			assertEquals(404,response.statusCode());
			assertEquals(xl.get("RepMessage"),response.jsonPath().get("Message"));
		}
		if (failcode.equals("400")){
			assertEquals(400,response.statusCode());
			assertEquals(xl.get("RepMessage"),response.jsonPath().get("Message"));
		}
		if (failcode.equals("405")){
			assertEquals(405,response.statusCode());
	
		}
	}
}
