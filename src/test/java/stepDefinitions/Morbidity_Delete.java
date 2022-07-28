package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;
import utility.ExcelUtil;


public class Morbidity_Delete extends Base{
	
	String MorbidityID ;
	String MorbidityName;
	
	Map<String, String> xl;
	String ReqParam;;
	String  Code;
	String method;
	 int Status;
	 int responseLength;
	  String Actual;
	 
	 
	@Given("User creates DELETE Method")
	public void user_creates_delete_method() throws IOException 
	{
	    requestSpecBuilder=given().spec(requestSpecification());
	}

	@When("User calls {string} {string} with {string}  http request from  {string} {int}")
	public void user_calls_with_http_request_from(String resource, String resource2, String method, String sheetName, Integer RowNumber) {
	   
		xl = ExcelUtil.getxlData(sheetName).get(RowNumber);
		
		MorbidityName =  xl.get("MorbidityName");;
		MorbidityID =  xl.get("MorbidityID");
		ReqParam = "MorbidityName="+MorbidityName+"&MorbidityTestId="+MorbidityID ;
	
		response = requestSpecBuilder.when().delete(resource(resource) + ReqParam);
		
     }
	
	@Then("User receive HTTP Status code and Verify by calling {string} with {string}")
	public void user_receive_http_status_code_and_verify_by_calling_with(String resource, String method) { 
			
		Code = xl.get("StatusCode");

		response = requestSpecBuilder.when().get(resource(resource)+MorbidityName);
		assertEquals(Integer.parseInt(Code), response.getStatusCode());
          assertEquals(MorbidityName,getJsonPath(response, "Items[0].MorbidityName").toString());
		
		}
	
	@Then("User receive HTTP {string} and JsonResponse body")
	public void user_receive_http_and_json_response_body(String string) 
	{
		Code = xl.get("StatusCode");
		assertEquals(Integer.parseInt(Code), response.getStatusCode());
	}

	
	
}
