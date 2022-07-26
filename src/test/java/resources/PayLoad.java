package resources;

public class PayLoad {
	
	public static String userpostPayLoad(String FirstName,String LastName,String Address1,String Address2,String City,String State,String Country,
			String Contact,String Email,String FoodCategory,String Allergy,String LoginUsername,String Password,String UserType,String DieticianId)
	
	{
		String userpost="{\r\n\t" + "\"FirstName\" : \""+FirstName+"\",\r\n\t" 
                                  + "\"LastName\" : \""+LastName+"\",\r\n\t" 
				                  + "\"Address\" : {\r\n\t"
                                  + "\"Address1\" : \""+Address1+"\",\r\n\t\t" 
				                  + "\"Address2\" : \""+Address2+ "\",\r\n\t\t" 
				                  + "\"City\" : \"" +City+"\",\r\n\t\t" 
				                  + "\"State\" : \"" +State+"\",\r\n\t\t"
				                  +"\"Country\" : \"" +Country+"\"\r\n\t" 
				                  + "},"
				                  + "\r\n\t" 
				                  + "\"Contact\" : \""+Contact+"\",\r\n\t" 
				                  + "\"Email\" : \""+Email+"\",\r\n\t"
				                  + "\"FoodCategory\" : \""+FoodCategory+"\",\r\n\t" 
				                  + "\"Allergy\" : \""+Allergy+"\",\r\n\t"
				                  + "\"LoginUsername\" : \""+LoginUsername+"\",\r\n\t"
				                  + "\"Password\" : \""+Password+"\",\r\n\t"
				                  + "\"UserType\" : \"" +UserType+"\",\r\n\t"
				                  + "\"DieticianId\": \""+DieticianId+"\"\r\n" 
				                  + " }";
		return userpost;
		
		
	}

}
