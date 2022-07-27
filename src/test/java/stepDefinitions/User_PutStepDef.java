package stepDefinitions;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.hamcrest.MatcherAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;
import resources.DieticianResources;
import resources.PayLoad;
import utility.ExcelUtil;

public class User_PutStepDef extends Base {

	
	DieticianResources resourceAPI;
	Map<String, String> xl;
	static String Code;
	static String method;
	static String ReqBody;
	static String ReqParam;
	static String ReqParam1;
	static String ReqParam2;
	static String userputReq ;
	int Status;

	@Given("User creates PUT Method EndPoint from {string} and {int}")
	public void user_creates_put_method_end_point_from_and(String sheetName, Integer RowNumber) throws IOException {

		xl = ExcelUtil.getxlData(sheetName).get(RowNumber);
		
		userputReq = PayLoad.createPayload(xl);
		requestSpecBuilder = given().spec(requestSpecification()).body(userputReq);

		//MatcherAssert.assertThat(userputReq,matchesJsonSchema(new File(getGlobalValue("UserPutReqSchema"))));

	}

	@When("User calls {string} Http Request with {string}")
	public void user_calls_Http_request_with(String resource, String method) 
	{
		    ReqParam1 = xl.get("param_DieticianId");
			ReqParam2 = xl.get("param_UserId");
			ReqParam = "DieticianId=" + ReqParam1 + "&UserId=" + ReqParam2;
			response = requestSpecBuilder.when().put(resource(resource) + ReqParam);
	}

	@Then("User receive http {string} and response body")
	public void user_receive_http_and_response_body(String statuscode) throws IOException {

		Status = Integer.parseInt(xl.get("ExpectedStatusCode"));

		if(Status==200)
		{	response.then().assertThat().body(matchesJsonSchemaInClasspath(getGlobalValue("UserPutResSchema")));
		}
		
		assertEquals(Status, response.getStatusCode());
	}
}
