package resources;

public enum DieticianResources {
	
	GetRecipe("Recipes/"),
	GETFoodCategory("Recipes/RecipeFoodCategory="),
	GetRecipeIngredent("Recipes/RecipeIngredient="),
	GetRecipeByNutrient("Recipes/RecipeNutrient="),
	GetRecipeByRecipeType("api/Recipes/RecipeType="),
	
	GetUserApi("Users"),
	GetUserByFirstName("Users/FirstName="),
	GetUserByUserType("Users/UserType="),
	GetUserByDieticianID("Users/DieticianId="),
	GetUserByContact("Users/Contact="),
	GetUserByEmail("Users/Email="),
	PutUsersbyDieticianID("Users/DieticianId= "),
	PutUsersbyUserId("&Userid="),
	DeleteUsersbyDieticianID("Users/DieticianId= "),
	DeleteUsersbyUserId("&Userid="),
	
	GetMorbidity("Morbidity"),
	GetMorbiditybyName("Morbidity/MorbidityName="),
	GetMorbiditybyTestid("Morbidity/MorbidityTestId="),
	
	PostMorbidity("Morbidity"),
	DeleteMorbidity("Morbidity/MorbidityName="),
	DeleteMorbiditybyTestId("&MorbidityTestId="),
	
	MorbidityAPI("Morbidity/"),
	UserApi("Users/");

	//PutMorbidity("Morbidity/MorbidityName="),
	//PutMorbiditybyTestId("&MorbidityTestId="),
	
    private String resource;

    DieticianResources(String resource)
    {
	   this.resource=resource;
    }

    public String getResource()
    {
    	return resource;
    }

}
