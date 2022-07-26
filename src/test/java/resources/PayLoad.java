package resources;

import java.util.Map;

public class PayLoad {
	public static String creatMorbidityPutBody(Map<String,String> xl) {
		
		String ReqBody = "{\r\n"
				+ "\"MorbidityMarkerRef\" : \"" + xl.get("MorbidityMarkerRef") + "\",\r\n"
				+ "\"MorbidityTestUnit\": \""+ xl.get("MorbidityTestUnit") +"\"\r\n"
				+ " } ";
		
		return ReqBody;
		
	}

}
