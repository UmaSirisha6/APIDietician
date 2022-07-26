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
	public void user_creates_get_method() throws IOException {

		req = given().spec(requestSpecification());

	}

	@When("User calls Get Https Request with {string} Endpoint")
	public void user_calls_get_https_request_with_endpoint(String resource) {
		resourceAPI = DieticianResources.valueOf(resource);
		response = req.when().get(resourceAPI.getResource());

	}

	@When("User calls {string} Https Request with {string} from excel sheet {string} and {int}")
	public void user_calls_https_request_with_from_excel_sheet_and(String resource, String method, String SheetName,
			Integer RowNumber) {

		resourceAPI = DieticianResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		xl = ExcelUtil.getxlData(SheetName).get(RowNumber);

		ByFirstName = xl.get("GetUserByFirstName");
		ByContact = xl.get("GetUserByContact");
		ByEmail = xl.get("GetUserByEmail");
		ByUserType = xl.get("GetUserByUserType");
		ByDieticianID = xl.get("GetUserByDieticianID");

		if (method.equalsIgnoreCase("GetByFirstName"))
			response = req.when().get((resourceAPI.getResource() + ByFirstName));
		else if (method.equalsIgnoreCase("GetByContact"))
			response = req.when().get((resourceAPI.getResource() + ByContact));
		else if (method.equalsIgnoreCase("GetByEmail"))
			response = req.when().get((resourceAPI.getResource() + ByEmail));
		else if (method.equalsIgnoreCase("GetByUserType"))
			response = req.when().get((resourceAPI.getResource() + ByUserType));
		else if (method.equalsIgnoreCase("GetByDieticianID"))
			response = req.when().get((resourceAPI.getResource() + ByDieticianID));

	}

	@Then("User should receive HTTP Status code and response fields for {string}")
	public void user_should_receive_http_status_code_and_response_fields_for(String method) throws IOException {

		if (method.equalsIgnoreCase("Get")) {

			res = req.then().spec(responseSpecification())
					.body(matchesJsonSchemaInClasspath(getGlobalValue("UserGetResSchema")));

		}

		else if (!method.equalsIgnoreCase("Get")) {
			code = xl.get("StatusCode");
			status = Integer.valueOf(code);
			System.out.println(status); // converting from string to integer
			assertEquals(status, response.getStatusCode());

			if (method.equalsIgnoreCase("GetByFirstName")) {
				FirstName = getJsonPath(response, "Items[0].FirstName").toString();

				assertEquals(ByFirstName, FirstName); // asserting the firstname from response with excel inputs

			} else if (method.equalsIgnoreCase("GetByContact")) {
				Contact = getJsonPath(response, "Items[0].Contact").toString();
				assertEquals(ByContact, Contact);

			} else if (method.equalsIgnoreCase("GetByEmail")) {
				Email = getJsonPath(response, "Items[0].Email").toString();
				assertEquals(ByEmail, Email);

			} else if (method.equalsIgnoreCase("GetByUserType")) {
				String User = getJsonPath(response, "Items[0].UserId").toString();
				UserType = User.substring(0, 2); // Getting first two letters of UserType from Response
				ByUserTypeID = xl.get("GetUserByUserTypeID");
				GivenUserType = ByUserTypeID.substring(0, 2);// Getting first two letters of Usertype from excel sheet
				assertEquals(GivenUserType, UserType); // DT==DT, then it is Dietician
			}

			else if (method.equalsIgnoreCase("GetByDieticianID")) {
				DieticianID = getJsonPath(response, "Items[0].UserId").toString();
				assertEquals(ByDieticianID, DieticianID);
			}

			if (status == 404) {
				ErrorMessage = xl.get("Message");
				Msg = getJsonPath(response, "Message");
				System.out.println(Msg);
				System.out.println(ErrorMessage);
				assertEquals(ErrorMessage, Msg);
			}
		}
	}

}
