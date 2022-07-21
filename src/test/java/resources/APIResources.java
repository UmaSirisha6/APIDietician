package resources;

public enum APIResources {
	
	GetRecipe("api/Recipes"),
	GETFoodCategory("api/Recipes/FoodCategory/"),
	GetRecipeIngredent("/api/Recipes/RecipeIngredient/"),
	GetRecipeByNutrient("/api/Recipes/RecipeNutrient/"),
	GetRecipeByRecipeType("/api/Recipes/RecipeType/"),
	
	GetUserApi("/users"),
	GetUserByContact("/users/getUserbyContact/"),
	GetUserByEmail("/users/getUserbyEmail/"),
	GetUserByDieticianID("/getUserbyDieticianId/"),
	GetUserByFirstName("/getUserbyFirstName/"),
	GetUserByUserType("/getUserbyUserType/"),
	Users("/users"), //user put , post , delete have same resource
		
	GetMorbiditybyName("/api/getMorbiditybyName/"),
	GetMorbiditybyTestid("/api/getMorbiditybyMorbidityTestId/"),
	GetMorbidity("/api/morbidity"),
	PostMorbidity("/api/morbidity"),
	PutMorbidity("/api/morbidity/"),
	DeleteMorbidity("/api/morbidity/");

	
    private String resource;

    APIResources(String resource)
    {
	   this.resource=resource;
    }

    public String getResource()
    {
    	return resource;
    }
}