package resources;

import java.util.List;
import java.util.Map;

public class PayLoad extends Base {

	static List<Map<String, String>> xl;

	public   String payload;
	
public static String creatMorbidityPutBody(Map<String,String> xl) {
		
		String ReqBody = "{\r\n"
				+ "\"MorbidityMarkerRef\" : \"" + xl.get("MorbidityMarkerRef") + "\",\r\n"
				+ "\"MorbidityTestUnit\": \""+ xl.get("MorbidityTestUnit") +"\"\r\n"
				+ " } ";
		
		return ReqBody;
	}

	public static String userpostPayLoad(Map<String,String> xl)
	
	{
		String userpost="{\r\n\t" + "\"FirstName\" : \""+xl.get("FirstName")+"\",\r\n\t" 
                                  + "\"LastName\" : \""+xl.get("LastName")+"\",\r\n\t" 
				                  + "\"Address\" : {\r\n\t"
                                  + "\"Address1\" : \""+xl.get("Address1")+"\",\r\n\t\t" 
				                  + "\"Address2\" : \""+xl.get("Address2")+ "\",\r\n\t\t" 
				                  + "\"City\" : \"" +xl.get("City")+"\",\r\n\t\t" 
				                  + "\"State\" : \"" +xl.get("State")+"\",\r\n\t\t"
				                  +"\"Country\" : \"" +xl.get("Country")+"\"\r\n\t" 
				                  + "},"
				                  + "\r\n\t" 
				                  + "\"Contact\" : \""+xl.get("Contact")+"\",\r\n\t" 
				                  + "\"Email\" : \""+xl.get("Email")+"\",\r\n\t"
				                  + "\"FoodCategory\" : \""+xl.get("FoodCategory")+"\",\r\n\t" 
				                  + "\"Allergy\" : \""+xl.get("Allergy")+"\",\r\n\t"
				                  + "\"LoginUsername\" : \""+xl.get("LoginUsername")+"\",\r\n\t"
				                  + "\"Password\" : \""+xl.get("Password")+"\",\r\n\t"
				                  + "\"UserType\" : \"" +xl.get("UserType")+"\",\r\n\t"
				                  + "\"DieticianId\": \""+xl.get("DieticianId")+"\"\r\n" 
				                  + " }";
		return userpost;	
	}

	
	public static String createPayload(Map<String,String> xl) 
	{
	
		
		String userPut = 	"{\r\n"
   		+ "  \"FirstName\": \" "+  xl.get("FirstName") +"\",\r\n"
   		+ "  \"LastName\": \" "+xl.get("LastName")+"\",\r\n"
   		+ "  \"Address\": {\r\n"
   		+ "    \"Address1\": \""+xl.get("Address1")+"\",\r\n"
   		+ "    \"Address2\": \""+xl.get("Address2")+"\",\r\n"
   		+ "    \"City\": \""+xl.get("City")+"\",\r\n"
   		+ "    \"State\": \""+xl.get("State")+"\",\r\n"
   		+ "    \"Country\": \""+xl.get("State")+"\"\r\n"
   		+ "  },\r\n"
   		+ "  \"Contact\": \""+xl.get("Country")+"\",\r\n"
   		+ "  \"Email\": \""+xl.get("Email")+"\",\r\n"
   		+ "  \"FoodCategory\": \""+xl.get("FoodCategory")+"\",\r\n"
   		+ "  \"Allergy\": \""+xl.get("Allergy")+"\"\r\n"
   		+ " }";
   		;

		return userPut;
	
	}

	public static String Payload(Map<String, String> xl) {
	
			
		String payload = "{\r\n"
			 		+ "  \"MorbidityName\": \""+xl.get("MorbidityName")+"\",\r\n"
			 		+ "  \"MorbidityTestName\": \""+ xl.get("MorbidityTestName")+"\",\r\n"
			 		+ "  \"MorbidityMarkerRef\": \""+xl.get("MorbidityMarkerRef")+ "\",\r\n"
			 		+ "  \"MorbidityTestUnit\": \""+xl.get("MorbidityTestUnit")+ " \"\r\n"
			 		+ "}";
		 
		 return payload;
			
	}

	
	
}
