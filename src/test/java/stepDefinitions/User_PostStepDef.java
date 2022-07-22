package stepDefinitions;

import org.apache.poi.sl.draw.geom.AdjustPointIf;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;


import resources.Base;

public class User_PostStepDef extends Base {
	
	RequestSpecification req;
	ResponseSpecification res;
	
	Response response;
	
	@Given("User creates POST Method EndPoint")
	public void user_creates_post_method_end_point() throws IOException {
		
		req = given().spec(requestSpecification()).pathParam("DieticianID","DT001").pathParam("USERID","UT001").body("");
		//data from excel sheet
	    
	}

	@When("User calls {string}  Http request with {string} from sheet {string}")
	public void user_calls_http_request_with_from_sheet(String resource, String method, String sheetname) {
		
	}
	@Then("User receive HTTP {string} and response body")
	public void user_receive_http_and_response_body(String string) {
		
		assertEquals(response.getStatusCode(),200);
		
	    
	}
	

}
