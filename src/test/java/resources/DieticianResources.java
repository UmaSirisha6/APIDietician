package resources;

public enum DieticianResources {
	

	GetRecipe("Recipes/"),
	GetFoodCategory("Recipes/RecipeFoodCategory="),
	GetRecipeIngredient("Recipes/RecipeIngredient="),
	GetRecipeByNutrient("Recipes/RecipeNutrient="),
	GetRecipeByRecipeType("Recipes/RecipeType="),
	
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
	
	PostMorbidity("Morbidity/"),
	PutMorbidity("Morbidity/MorbidityName="),
	PutMorbiditybyTestId("&MorbidityTestId="),
	DeleteMorbidity("Morbidity/MorbidityName="),
	DeleteMorbiditybyTestId("&MorbidityTestId="),
	PostatchMorbidity("Morbidity/"),
	GetMorbidityTestid("Morbidity/MoidityTestId="),	
	GetMorbidityName("Moidity/MorbidityName="),
	getRecipe("Recips/"),
	MorbidityAPI("Morbidity/"),
	UserApi("Users/"),

	UserApiWrong("users/");


	
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