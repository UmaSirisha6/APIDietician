package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.hamcrest.Matchers;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import resources.Base;
import resources.DieticianResources;
import utility.ExcelUtil;



public class User_DeleteStepDef extends Base{
	
	
	Response response; 
	ExcelUtil xlutil;
	DieticianResources resourceAPI;
	Map<String, String> xl;
	String ReqParam;
	String ReqParam1;
	String ReqParam2;
	int Status;
	
	@Given("User creates DELETE Method EndPoint")
	public void user_creates_delete_method_end_point() throws IOException {
		req = given().spec(requestSpecification());
	}

	@When("User calls {string} http Request with {string} from {string} and {int}")
	public void user_calls_http_request_with_from_and(String resource, String method, String sheetName, Integer RowNumber) {
		
		resourceAPI = DieticianResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		System.out.println(resource);
		System.out.println(method +  sheetName);
	 	xl = ExcelUtil.getxlData(sheetName).get(RowNumber);
	 	System.out.println(xl);
	 	if (method.equalsIgnoreCase("DELETE"))
		{
			ReqParam1=xl.get("param_DieticianId");
			ReqParam2=xl.get("param_UserId");
			
			ReqParam ="DieticianId="+ReqParam1+"&UserId="+ReqParam2;
			response = req.when()
					.delete(resourceAPI.getResource() + ReqParam);
				
			System.out.println(resourceAPI.getResource() + ReqParam);
			System.out.println(response.asPrettyString());

		}
	}

	@Then("User receive HTTP {string} and response body for UserDelete")
	public void user_receive_http_and_response_body_for_user_delete(String statuscode) {
		
		res = req.then().spec(responseSpecification()).body("Message",Matchers.equalTo(xl.get("ExpectedResBody_Message")));
        
		Status = Integer.valueOf(xl.get("ExpectedStatusCode"));
		assertEquals(Status,response.getStatusCode());
	   
	}
}
