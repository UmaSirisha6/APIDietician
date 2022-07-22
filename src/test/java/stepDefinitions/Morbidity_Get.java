package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import resources.Base;
import resources.DieticianResources;
import utility.ExcelUtil;

public class Morbidity_Get extends Base {

	Response response;
	ExcelUtil xlutil;
	DieticianResources resourceAPI;
	Map<String, String> xl;
	String expectedMorbidityID;
	String expectedMorbidityName;
	String Code;
	String method;
	int Status;
	
	

	@Given("User creates GET Method Endpoint")
	public void user_creates_get_method_endpoint() throws IOException {
		req = given().spec(requestSpecification());
	}

	@When("User calls {string} Https Request with {string} from sheet {string}")
	public void user_calls_with_https_request(String resource, String method, String sheetName) {
		// constructor will be called with value of resource which you pass
       
		resourceAPI = DieticianResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
          
		// Data from excel

		xl = ExcelUtil.getxlData(sheetName);
		
		expectedMorbidityName = xl.get("MorbidityName");
		expectedMorbidityID = xl.get("MorbidityID");
	

		System.out.println(resourceAPI.getResource() + expectedMorbidityID + "/ " + expectedMorbidityName);
		if (method.equalsIgnoreCase("GETByName"))
			response = req.when().get((resourceAPI.getResource() + expectedMorbidityName));
		else 
			if (method.equalsIgnoreCase("GET"))
				response = req.when().get((resourceAPI.getResource()));

		else if (method.equalsIgnoreCase("GETByID")) {
			response = req.when().get((resourceAPI.getResource() + expectedMorbidityID));

		}

	}

	@Then("User receive HTTP Status code and success message")
	public void user_receive_http_status_code_and_success_message() {

		Code = xl.get("StatusCode");
	    Status = Integer.valueOf(Code);
	  
	    
	    assertEquals(response.getStatusCode(),Status);

	}

}
