package resources;

public enum APIResources {
	
	GetRecipe("api/Recipes"),
	GETFoodCategory("/Recipes/FoodCategory/");

	
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