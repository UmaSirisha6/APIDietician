package stepDefinitions;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import resources.Base;
import utility.ExcelUtil;

public class User_Get extends Base {

	Response response;
	ExcelUtil xlutil;
	Map<String, String> xl;
	public String ByFirstName;
	public String ByContact;
	public String ByEmail;
	public String ByUserType;
	public String ByDieticianID;
	int status;
	public String ErrorMessage;
	public String Msg;
	public String FirstName;
	public String Contact;
	public String Email;
	public String UserType;
	public String DieticianID;
	public String GivenUserType;
	public String ByUserTypeID;
	public Response response1;
	static String StatusCode;
	static String ErrorCode;
	static String badRequest;

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

	@Then("User should receive HTTP Status code and response fields")
	public void user_should_receive_http_status_code_and_response_fields() throws IOException {
		
		int actualStatusCode = response.getStatusCode();
		 
		if(actualStatusCode == Integer.parseInt(getGlobalValue("StatusCode")))
		responseSpecBuilder = requestSpecBuilder.then().spec(responseSpecification()).body(matchesJsonSchemaInClasspath(getGlobalValue("UserGetResSchema")));
		else
			assertEquals(Integer.parseInt(getGlobalValue("BadRequest")),actualStatusCode);
	
	}
	
	@Then("User should receive HTTP Status code and response fields for {string}")
	public void user_should_receive_http_status_code_and_response_fields_for(String method) throws IOException {


		if (method == "GetByFirstName") 
		{
			if (Integer.parseInt(xl.get("StatusCode"))==Integer.parseInt(getGlobalValue("StatusCode"))) 
			{
				responseSpecBuilder = requestSpecBuilder.then()
						.body(matchesJsonSchemaInClasspath(getGlobalValue("GetRecipeSchema"))).and()
						.body(containsString("ByFirstname"));
				assertEquals(ByFirstName, response.jsonPath().get("Items.FirstName"));
		}
		}

		    else if (method == "GetByContact")
		 {
			if (Integer.parseInt(xl.get("StatusCode")) == Integer.parseInt(getGlobalValue("StatusCode"))) 
			
			{
				responseSpecBuilder = requestSpecBuilder.then().spec(responseSpecification())
						.body(matchesJsonSchemaInClasspath(getGlobalValue("GetRecipeSchema"))).and()
						.body(containsString("ByContact"));
		 }
		 }
			else if (method == "GetByEmail") 
		 {
				if (Integer.parseInt(xl.get("StatusCode")) == Integer.parseInt(getGlobalValue("StatusCode"))) 
				{responseSpecBuilder = requestSpecBuilder.then().spec(responseSpecification())
						.body(matchesJsonSchemaInClasspath(getGlobalValue("GetRecipeSchema"))).and()
						.body(containsString("ByEmail"));
				}
		} else if (method == "GetByUserType")
		{
			if (Integer.parseInt(xl.get("StatusCode")) == Integer.parseInt(getGlobalValue("StatusCode"))) 
			{	responseSpecBuilder = requestSpecBuilder.then().spec(responseSpecification())
						.body(matchesJsonSchemaInClasspath(getGlobalValue("GetRecipeSchema")));

				String User = getJsonPath(response, "Items[0].UserId").toString();
				UserType = User.substring(0, 2);
				ByUserTypeID = xl.get("GetUserByUserTypeID");
				GivenUserType = ByUserTypeID.substring(0, 2);
				assertEquals(GivenUserType, UserType);
			}
		} else if (method == "GetByDieticianID")
		{
			if (Integer.parseInt(xl.get("StatusCode")) == Integer.parseInt(getGlobalValue("StatusCode"))) 
			{	responseSpecBuilder = requestSpecBuilder.then().spec(responseSpecification())
						.body(matchesJsonSchemaInClasspath(getGlobalValue("GetRecipeSchema"))).and()
						.body(containsString("ByDieticianID"));
			}
      		} else
				{  
				assertEquals(Integer.parseInt(xl.get("StatusCode")), response.getStatusCode());

		        }
		}
	
}
