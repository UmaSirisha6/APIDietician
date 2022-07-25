package stepDefinitions;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import resources.Base;
import resources.DieticianResources;
import utility.ExcelUtil;
//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class Recipe_Get extends Base {

	Response response;

	DieticianResources resourceAPI;
	Map<String, String> xl;
	String expectedRecipes;
	String expectedFoodCategory;
	String expectedIngredient;
	String expectedNutrient;
	String expectedRecipeType;
String code;
int status;
	@Given("User creates GET Method Endpoint")
	public void user_creates_get_method_endpoint() throws IOException {
		req = given().spec(requestSpecification());
	}

	@When("User calls {string} http request with {string}")
	public void user_calls_http_request_with(String resource, String method) {
		// constructor will be called with value of resource which you pass
		
		resourceAPI = DieticianResources.valueOf(resource);

		response = req.when().get(resourceAPI.getResource());
		// System.out.println(resourceAPI.getResource());
	}

	@When("User calls {string} http request with {string} from {string} and {int}")
	public void user_calls_http_request_with_from(String resource, String method, String sheetName, Integer RowNumber) {
		// constructor will be called with value of resource which you pass
		
		resourceAPI = DieticianResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		// Data from excel
		xl = ExcelUtil.getxlData(sheetName).get(RowNumber);

		expectedRecipes = xl.get("GetRecipes");
		expectedFoodCategory = xl.get("GetRecipeByFoodCategory");
		expectedIngredient = xl.get("GetRecipeByIngredient");
		expectedNutrient = xl.get("GetRecipeByNutrient");
		expectedRecipeType = xl.get("GetRecipeByRecipeType");

	if( (method.equalsIgnoreCase("GetRecipe")))
		response = req.when().get(resourceAPI.getResource());
	else if (method.equalsIgnoreCase("GetRecipeByFoodCategory"))
			response = req.when().get((resourceAPI.getResource()+expectedFoodCategory));
		else if (method.equalsIgnoreCase("GetRecipeByIngredient"))
		response = req.when().get((resourceAPI.getResource()+expectedIngredient));
		else if (method.equalsIgnoreCase("GetRecipeByNutrient"))
		response = req.when().get(resourceAPI.getResource()+expectedNutrient);
		else if (method.equalsIgnoreCase("GetRecipeByRecipeType"))
			response =  req.when().get(resourceAPI.getResource()+expectedRecipeType);
		System.out.println(response);
	}
	
	

@Then("User receive HTTP Status code in {string} method and response body")
public void user_receive_http_status_code_in_method_and_response_body(String method)throws NullPointerException { 
// converting from string to integer
	

		code = xl.get("Status code");
		System.out.println(code);
		this.status = Integer.valueOf(code);
		System.out.println(this.status);
		if(method.equalsIgnoreCase("GetRecipe"))
		
		assertEquals(200,response.getStatusCode());

		else if  (method.equalsIgnoreCase("GetRecipeByFoodCategory"))
			res = req.then().spec(responseSpecification()).body(containsString("Vegetarian"));
		else if(method.equalsIgnoreCase("InvalidFoodCategory"))
			assertEquals(this.status,response.getStatusCode());//from excel
		else if(method.equalsIgnoreCase("GetRecipeByIngredient"))
			res = req.then().spec(responseSpecification()).body(containsString("curd"));
		else if(method.equalsIgnoreCase("InvalidIngredient"))
			assertEquals(this.status,response.getStatusCode());
		else if(method.equalsIgnoreCase("GetRecipeByNutrient"))
			res = req.then().spec(responseSpecification()).body(containsString("Energy 56 cal"));
		else if(method.equalsIgnoreCase("InvalidNutrient"))
			assertEquals(this.status,response.getStatusCode());
		else if(method.equalsIgnoreCase("GetRecipeByRecipeType"))
			res = req.then().spec(responseSpecification()).body(containsString("Lunch"));
		else if(method.equalsIgnoreCase("InvalidRecipeType"))
			assertEquals(this.status,response.getStatusCode());
	}


}