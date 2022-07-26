package resources;

public class PayLoad {
	
	
	public static String createPayload(String Firstname,String Lastname,String Address1,String Address2,String Country,
			String City,String State,String Contact, String Email,String FoodCategory, String Allergy) {
	
		
		String userPut = 	"{\r\n"
   		+ "  \"FirstName\": \" "+ Firstname +"\",\r\n"
   		+ "  \"LastName\": \" "+Lastname+"\",\r\n"
   		+ "  \"Address\": {\r\n"
   		+ "    \"Address1\": \""+Address1+"\",\r\n"
   		+ "    \"Address2\": \""+Address2+"\",\r\n"
   		+ "    \"City\": \""+Country+"\",\r\n"
   		+ "    \"State\": \""+City+"\",\r\n"
   		+ "    \"Country\": \""+State+"\"\r\n"
   		+ "  },\r\n"
   		+ "  \"Contact\": \""+Contact+"\",\r\n"
   		+ "  \"Email\": \""+Email+"\",\r\n"
   		+ "  \"FoodCategory\": \""+FoodCategory+"\",\r\n"
   		+ "  \"Allergy\": \""+Allergy+"\"\r\n"
   		+ "}";

		return userPut;
	}

}
