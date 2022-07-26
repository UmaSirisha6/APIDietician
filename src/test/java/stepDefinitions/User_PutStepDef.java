package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import resources.Base;
import resources.DieticianResources;
import resources.PayLoad;
import utility.ExcelUtil;

public class User_PutStepDef extends Base {

	Response response;
	ExcelUtil xlutil;
	DieticianResources resourceAPI;
	Map<String, String> xl;
	String expectedFirstName;
	String expectedLastName;
	String expectedAddress1;
	String expectedAddress2;
	String expectedCity;
	String expectedState;
	String expectedCountry;
	String expectedContact;
	String expectedEmail;
	String expectedFoodCategory;
	String expectedAllergy;
	String Code;
	String method;
	String ReqBody;
	String ReqParam;
	String ReqParam1;
	String ReqParam2;
	int Status;

	@Given("User creates PUT Method EndPoint from {string} and {int}")
	public void user_creates_put_method_end_point_from_and(String sheetName, Integer RowNumber) throws IOException {

		xl = ExcelUtil.getxlData(sheetName).get(RowNumber);
		expectedFirstName = xl.get("FirstName");
		expectedLastName = xl.get("LastName");
		expectedAddress1 = xl.get("Address1");
		expectedAddress2 = xl.get("Address2");
		expectedCity = xl.get("City");
		expectedState = xl.get("State");
		expectedCountry = xl.get("Country");
		expectedContact = xl.get("Contact");
		expectedEmail = xl.get("Email");
		expectedFoodCategory = xl.get("FoodCategory");
		expectedAllergy = xl.get("Allergy");

		String userputReq = PayLoad.createPayload(expectedFirstName, expectedLastName, expectedAddress1,
				expectedAddress2, expectedCountry, expectedCity, expectedState, expectedContact, expectedEmail,
				expectedFoodCategory, expectedAllergy);
		req = given().spec(requestSpecification()).body(userputReq);

		MatcherAssert.assertThat(userputReq,
				matchesJsonSchema(new File("./src/test/resources/JsonSchema/UserPutReqSchema.json")));

	}

	@When("User calls {string} Https Request with {string}")
	public void user_calls_https_request_with(String resource, String method) {

		resourceAPI = DieticianResources.valueOf(resource);

		if (method.equalsIgnoreCase("PUT")) {
			
			ReqParam1 = xl.get("param_DieticianId");
			ReqParam2 = xl.get("param_UserId");

			ReqParam = "DieticianId=" + ReqParam1 + "&UserId=" + ReqParam2;

			response = req.when().put(resourceAPI.getResource() + ReqParam);

		}

	}

	@Then("User receive HTTP {string} and response body")
	public void user_receive_http_and_response_body(String statuscode) {

		Status = Integer.valueOf(xl.get("ExpectedStatusCode"));

		assertEquals(Status, response.getStatusCode());
	}
}
