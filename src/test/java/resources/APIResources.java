package resources;

public enum APIResources {
	
	GetRecipe("api/Recipes"),
	GETFoodCategory("api/Recipes/FoodCategory/"),
GETRecipeIngredient("api/Recipes/RecipeIngredient"),
GETRecipeNutrient("api/Recipes/RecipeNutrient"),
GETREecipeType("api/Recipes/RecipeType");
	
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