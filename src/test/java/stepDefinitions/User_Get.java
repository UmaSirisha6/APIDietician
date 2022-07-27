package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import resources.Base;
import resources.DieticianResources;
import utility.ExcelUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class User_Get extends Base {

	Response response;
	ExcelUtil xlutil;
	DieticianResources resourceAPI;
	Map<String, String> xl;
	public String ByFirstName;
	public String ByContact;
	public String ByEmail;
	public String ByUserType;
	public String ByDieticianID;
	String code;
	int status;
	String ErrorMessage;
	String Msg;
	String FirstName;
	String Contact;
	String Email;
	String UserType;
	String DieticianID;
	String GivenUserType;
	String ByUserTypeID;
	Response response1;

	@Given("User creates GET Method")
	public void user_creates_get_method() throws IOException 
	{
		requestSpecBuilder = given().spec(requestSpecification());
	}

	@When("User calls Get Https Request with {string} Endpoint")
	public void user_calls_get_https_request_with_endpoint(String resource)
	{
		response = requestSpecBuilder.when().get(resource(resource));
	}

	@When("User calls {string} Https Request with {string} from excel sheet {string} and {int}")
	public void user_calls_https_request_with_from_excel_sheet_and(String resource, String method, String SheetName,
			Integer RowNumber) {

		xl = ExcelUtil.getxlData(SheetName).get(RowNumber);

		ByFirstName = xl.get("GetUserByFirstName");
		ByContact = xl.get("GetUserByContact");
		ByEmail = xl.get("GetUserByEmail");
		ByUserType = xl.get("GetUserByUserType");
		ByDieticianID = xl.get("GetUserByDieticianID");
		

		switch (method) {
		case "GetByFirstName":
			response = requestSpecBuilder.when().get(resource(resource) + ByFirstName);
			break;
		case "GetByContact":
			response = requestSpecBuilder.when().get((resource(resource)) + ByContact);
			break;
		case "GetByEmail":
			response = requestSpecBuilder.when().get(resource(resource) + ByEmail);
			break;
		case "GetByUserType":
			response = requestSpecBuilder.when().get(resource(resource) + ByUserType);
			break;
		case "GetByDieticianID":
			response = requestSpecBuilder.when().get(resource(resource) + ByDieticianID);
		}
	}

	@Then("User should receive HTTP Status code and response fields for {string}")
	public void user_should_receive_http_status_code_and_response_fields_for(String method) throws IOException {

		if (method.equalsIgnoreCase("Get")) 
		{
			responseSpecBuilder = requestSpecBuilder.then().spec(responseSpecification()).body(matchesJsonSchemaInClasspath(getGlobalValue("UserGetResSchema")));
		}

		else if (!method.equalsIgnoreCase("Get")) {
			code = xl.get("StatusCode");
			status = Integer.parseInt(code);
			
			assertEquals(status, response.getStatusCode());

			if (method.equalsIgnoreCase("GetByFirstName")) 
			{
				FirstName = getJsonPath(response,"Items[0].FirstName").toString();
                            assertEquals(ByFirstName, FirstName); 

			} else if (method.equalsIgnoreCase("GetByContact")) 
			{
				Contact = getJsonPath(response, "Items[0].Contact").toString();
				assertEquals(ByContact, Contact);

			} else if (method.equalsIgnoreCase("GetByEmail")) 
			{
				Email = getJsonPath(response, "Items[0].Email").toString();
				assertEquals(ByEmail, Email);

			} else if (method.equalsIgnoreCase("GetByUserType")) {
				String User = getJsonPath(response, "Items[0].UserId").toString();
				UserType = User.substring(0, 2); 
				ByUserTypeID = xl.get("GetUserByUserTypeID");
				GivenUserType = ByUserTypeID.substring(0, 2);
				assertEquals(GivenUserType, UserType);
			}

			else if (method.equalsIgnoreCase("GetByDieticianID")) {
				DieticianID = getJsonPath(response, "Items[0].UserId").toString();
				assertEquals(ByDieticianID, DieticianID);
			}

			if (status == 404) {
				ErrorMessage = xl.get("Message");
				Msg = getJsonPath(response, "Message");
			assertEquals(ErrorMessage, Msg);
			}
		}
	}

}
