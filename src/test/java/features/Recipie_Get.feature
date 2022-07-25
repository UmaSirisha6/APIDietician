@GetRecipeAPI
Feature: Checking Get Https Request in Recipe

  Background: Authorization is set to "Basic Auth"
    Given User creates GET Method Endpoint

  @AllRecipes
  Scenario: Check all the recipes available
    When User calls "GetRecipe" http request with "GetRecipe"
    Then User receive HTTP Status code in "GetRecipe" method and response body

  @INVALIDENDPOINT
  Scenario: Check all the recipes available
    When User calls "getRecipe" http request with "GetRecipe"
     Then User receive HTTP Status code in "GetRecipe" method and response body

  #GetRecipeByFoodCategory
  @GetRecipeByFoodCategory
  Scenario Outline: Check the recipes FoodCategory Endpoint
    When User calls "GetFoodCategory" http request with "GetRecipeByFoodCategory" from "<sheetName>" and <RowNumber>
    Then User receive HTTP Status code in "GetRecipesByFoodCategory" method and response body

    Examples: 
      | sheetName  | RowNumber |
      | GETRecipes |         0 |
      | GETRecipes |         1 |

  #GetRecipeByFoodCategory
  @GetRecipeByFoodCategoryINVALID
  Scenario Outline: Check the recipes FoodCategory Endpoint
    When User calls "GetFoodCategory" http request with "GetRecipeByFoodCategory" from "<sheetName>" and <RowNumber>
    Then User receive HTTP Status code in "GetRecipesByFoodCategory" method and response body

    Examples: 
      | sheetName  | RowNumber |
      | GETRecipes |         4 |
      | GETRecipes |         5 |
      | GETRecipes |         6 |

  #GetRecipeByIngredient
  @GetRecipeByIngredient
  Scenario Outline: Check the recipes FoodIngredient Endpoint
    When User calls "GetRecipeIngredient" http request with "GetRecipeByIngredient" from "<sheetName>" and <RowNumber>
    Then User receive HTTP Status code in "GetRecipesByIngredient" method and response body

    Examples: 
      | sheetName  | RowNumber |
      | GETRecipes |         0 |
      | GETRecipes |         1 |
      | GETRecipes |         2 |
      

  #GetRecipeByIngredient
  @GetRecipeByIngredientINVALID
  Scenario Outline: Check the recipes FoodIngredient Endpoint
    When User calls "GetRecipeIngredient" http request with "GetRecipeByIngredient" from "<sheetName>" and <RowNumber>
    Then User receive HTTP Status code in "GetRecipesByIngredient" method and response body

    Examples: 
      | sheetName  | RowNumber |
      | GETRecipes |         4 |
      | GETRecipes |         5 |

  #Getrecipe by nutrient
  @GetRecipeByNutrient
  Scenario Outline: To get all the Recipe Nutrient record with valid data
    When User calls "GetRecipeByNutrient" http request with "GetRecipeByNutrient" from "<sheetName>" and <RowNumber>
    Then User receive HTTP Status code in "GetRecipesByNutrient" method and response body

    Examples: 
      | sheetName  | RowNumber |
      | GETRecipes |         0 |
      | GETRecipes |         1 |

  #Getrecipe by nutrient
  @GetRecipeByNutrientINVALIDNUTRIENTDETAILS
  Scenario Outline: To get all the Recipe Nutrient record with valid data
    When User calls "GetRecipeByNutrient" http request with "GetRecipeByNutrient" from "<sheetName>" and <RowNumber>
    Then User receive HTTP Status code in "GetRecipesByNutrient" method and response body

    Examples: 
      | sheetName  | RowNumber |
      | GETRecipes |         4 |
      | GETRecipes |         5 |
      | GETRecipes |         6 |
      | GETRecipes |         7 |

  #GetRecipeByRecipeType
  @GetRecipeByRecipeType
  Scenario Outline: To get all the Recipe Type with Valid Records
    When User calls "GetRecipeByRecipeType" http request with "GetRecipeByRecipeType" from "<sheetName>" and <RowNumber>
    Then User receive HTTP Status code in "GetRecipeByRecipeType" method and response body

    Examples: 
      | sheetName  | RowNumber |
      | GETRecipes |         0 |
      | GETRecipes |         1 |
      | GETRecipes |         2 |
      | GETRecipes |         3 |

  #GetRecipeByRecipeTypeInvalid
  @GetRecipeByRecipeTypeInvalid
  Scenario Outline: To get all the Recipe Type with InValid Records
    When User calls "GetRecipeByRecipeType" http request with "GetRecipeByRecipeType" from "<sheetName>" and <RowNumber>
    Then User receive HTTP Status code in "GetRecipeByRecipeType" method and response body

    Examples: 
      | sheetName  | RowNumber |
      | GETRecipes |         4 |
      | GETRecipes |         5 |
      | GETRecipes |         6 |
      | GETRecipes |         7 |
      | GETRecipes |         8 |
      | GETRecipes |         9 |
      | GETRecipes |        10 |
      | GETRecipes |        11 |
