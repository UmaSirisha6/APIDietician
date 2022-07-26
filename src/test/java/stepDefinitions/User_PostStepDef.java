package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.hamcrest.Matchers;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import resources.Base;
import resources.DieticianResources;
import resources.PayLoad;
import utility.ExcelUtil;

public class User_PostStepDef extends Base {

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
	String expectedLoginUsername;
	String expectedPassword;
	String expectedUserType;
	String expectedDieticianId;
	String Code;
	String method;
	String ReqBody;
	int Status;

	@Given("User creates POST Method EndPoint  with data from {string} and {int}")
	public void user_creates_post_method_end_point_with_data_from_and(String sheetName, Integer RowNumber) throws IOException {
	
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
		expectedLoginUsername = xl.get("LoginUsername");
		expectedPassword = xl.get("Password");
		expectedUserType = xl.get("UserType");
		expectedDieticianId = xl.get("DieticianId");
		
		
		
		req = given().spec(requestSpecification()).body(PayLoad.userpostPayLoad(expectedFirstName,
				expectedLastName, expectedAddress1, expectedAddress2, expectedCity,
				expectedState,expectedCountry, expectedContact, expectedEmail, 
				expectedFoodCategory, expectedAllergy,expectedLoginUsername,
				expectedPassword,expectedUserType,expectedDieticianId));
	}


	@When("User calls {string} Https Request with {string}")
	public void user_calls_http_request_with(String resource, String method) {

		resourceAPI = DieticianResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		if (method.equalsIgnoreCase("POST")) {

			System.out.println(ReqBody);
			
			response = req.when().post(resourceAPI.getResource());

			System.out.println(response.asPrettyString());

			
		}

	}

	@Then("User receive HTTP {string} and response body")
	public void user_receive_http_and_response_body(String StatusCode) {
		Status = Integer.valueOf(xl.get("ExpectedStatusCode"));
		if(Status==200)
		{
			response.then().assertThat().body(matchesJsonSchemaInClasspath("./JsonSchema/UserPostResSchema.json"));

		}
		
		
		res = req.then().spec(responseSpecification()).body("message",Matchers.equalTo(xl.get("Message")));
		

		assertEquals(response.getStatusCode(),Status);


	}

}
