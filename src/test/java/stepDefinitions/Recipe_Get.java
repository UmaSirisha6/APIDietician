package stepDefinitions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;
import utility.ExcelUtil;

public class Recipe_Get extends Base {

	Map<String, String> xl;
	static String expectedRecipes;
	static String expectedFoodCategory;
	static String expectedIngredient;
	static String expectedNutrient;
	static String expectedRecipeType;
	static String code;
	static String StatusCode;
	static String ErrorCode;
	static String badRequest;

	@When("user calls {string} http with Get method")
	public void user_calls_http_with_get_method(String resource) throws NullPointerException {
		
		response = requestSpecBuilder.when().get(resource(resource));

	}

	@When("User calls {string} http request with {string} from {string} and {int}")
	public void user_calls_http_request_with_from(String resource, String method, String sheetName, Integer RowNumber) {
		
		xl = ExcelUtil.getxlData(sheetName).get(RowNumber);

		expectedRecipes = xl.get("GetRecipes");
		expectedFoodCategory = xl.get("GetRecipeByFoodCategory");
		expectedIngredient = xl.get("GetRecipeByIngredient");
		expectedNutrient = xl.get("GetRecipeByNutrient");
		expectedRecipeType = xl.get("GetRecipeByRecipeType");

		switch (method) {
		case "GetRecipe":
			response = requestSpecBuilder.when().get(resource(resource));
			break;
		case "GetRecipeByFoodCategory":
			response = requestSpecBuilder.when().get(resource(resource) + expectedFoodCategory);
			break;
		case "GetRecipeByIngredient":
			response = requestSpecBuilder.when().get(resource(resource) + expectedIngredient);
			break;
		case "GetRecipeByNutrient":
			response = requestSpecBuilder.when().get(resource(resource) + expectedNutrient);
			break;
		case "GetRecipeByRecipeType":
			response = requestSpecBuilder.when().get(resource(resource) + expectedRecipeType);
			break;
		}

	}

	@Then("User receive HTTP Status code and response body")
	public void user_receive_http_status_code_and_response_body() throws IOException
	{

		String StatusCode = getGlobalValue("StatusCode");
        assertEquals(Integer.parseInt(StatusCode), response.getStatusCode());
	}

	@Then("User receive HTTP Status code in {string} method and response body")
	public void user_receive_http_status_code_in_method_and_response_body(String method) throws IOException {


		code = xl.get("Status code");
	    StatusCode = getGlobalValue("StatusCode");
		ErrorCode = getGlobalValue("ErrorCode");
		badRequest = getGlobalValue("BadRequest");

		if (Integer.parseInt(code) == Integer.parseInt(StatusCode)) 
		{
			responseSpecBuilder = requestSpecBuilder.then().spec(responseSpecification()). body(matchesJsonSchemaInClasspath(getGlobalValue("GetRecipeSchema")));
			
		} 
		else if (Integer.parseInt(code) == Integer.parseInt(ErrorCode)) {
			assertEquals(Integer.parseInt(code), response.getStatusCode());
		} else if (Integer.parseInt(code) == Integer.parseInt(badRequest)) {
			assertEquals(Integer.parseInt(code), response.getStatusCode());

		}

	}

}
