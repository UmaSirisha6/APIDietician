@GetRecipeAPI
Feature: Checking Get Https Request in Recipe
Background: Authorization is set to "Basic Auth" 
Given User creates GET Method Endpoint

@AllRecipes
Scenario: Check all the recipes available
When User calls "GetRecipes" http request with "Get"
Then User receive HTTP "Status code" and response body

Scenario: To get all the FoodCategory with Valid Records
When User calls "GetRecipesbyFoodCategory" http request with "GetFoodCategory" from sheet "GETRecipes"
Then User receive HTTP "Status code" and response body

Scenario: To get all the FoodCategory with Invalid Records
When User calls "GetRecipesbyFoodCategory" http request with "GetFoodCategory" from sheet "GetRecipes"
Then User receive HTTP "Status code" and response body

Scenario: To get all the Recipe Ingredients record with valid data
When User calls "GetRecipesbyRecipeIngredients" http request with "GetRecipeIngredient" from sheet "GETRecipes"
Then User receive HTTP "Status code" and response body

Scenario: To get all the Recipe Ingredients record with Invalid data
When User calls "GetRecipesbyRecipeIngredients" http request with "GetRecipeIngredient" from sheet "GETRecipes"
Then User receive HTTP "Status code" and response body

Scenario: To get all the Recipe Nutrient record with valid data
When User calls "GetRecipesbyRecipeNutrient" http request with "GetRecipeNutrient" from sheet "GETRecipes"
Then User receive HTTP "Status code" and response body

Scenario: To get all the Recipe Nutrient record with Invalid data
When User calls "GetRecipesbyRecipeNutrient" http request with "GetRecipeNutrient" from sheet "GETRecipes"
Then User receive HTTP "Status code" and response body

Scenario: To get all the Recipe Type with Valid Records
When User calls "GetRecipesbyRecipeType" http request with "GetRecipeType" from sheet "GetRecipes"
Then User receive HTTP "Status code" and response body

Scenario: To get all the Recipe Type with Invalid Records
When User calls "GetRecipesbyRecipeType" http request with "GetRecipeType" from sheet "GetRecipes"
Then User receive HTTP "Status code" and response body