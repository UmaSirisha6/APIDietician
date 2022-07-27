package resources;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.ExcelUtil;

public class BatchPayload extends Base

{
	static RequestSpecification req;
	static String MorbidityName;
	static String MorbidityTestName;
	static String MorbidityMarkerRef;
	static String MorbidityTestUnit;
	static String jsonPayload;
	static DieticianResources resourceAPI;
	static Response response;
	int actualStatusCode;
	static String StatusCode;
	static int statusCode;
	static String Expectedmessage;
	static Map<String, String> xl;


	public static List<Map<String, Object>> creatingBatchPayload(String sheetName) {
		
		
		 List<Map<String, String>> xl = ExcelUtil.getxlData(sheetName);
		 List<Map<String, Object>> jsonArrayPayload = new ArrayList<Map<String, Object>>();
		 
		 int excelSize = xl.size();
		 for (int i = 0; i < excelSize; i++) {


				MorbidityName = xl.get(i).get("MorbidityName");
				MorbidityTestName = xl.get(i).get("MorbidityTestName");
				MorbidityMarkerRef = xl.get(i).get("MorbidityMarkerRef");
				MorbidityTestUnit = xl.get(i).get("MorbidityTestUnit");

				if (MorbidityName != null && !MorbidityName.isEmpty()) {
					
					Map<String,Object> lMap = new HashMap<String, Object>();
					
					lMap.put("MorbidityName", MorbidityName);
					lMap.put("MorbidityTestName", MorbidityTestName);
					lMap.put("MorbidityMarkerRef", MorbidityMarkerRef);
					lMap.put("MorbidityTestUnit", MorbidityTestUnit);

					jsonArrayPayload.add(lMap);
				}
				
			}
		
			
			return jsonArrayPayload;
		
	}
	
	
	 @JsonIgnoreProperties(ignoreUnknown=true)
		public static void getBatchPayload(String sheetName) throws IOException {

			List<Map<String, String>> xl = ExcelUtil.getxlData(sheetName);
	    	DieticianResources resourceAPI = DieticianResources.valueOf("PostMorbidity");
			
			int excelSize = xl.size();

			List<Map<String, Object>> jsonArrayPayload = new ArrayList<Map<String, Object>>();

			int triggerCount = 2;
		
			for (int i = 0; i < excelSize; i++) {

				MorbidityName = xl.get(i).get("MorbidityName");
				MorbidityTestName = xl.get(i).get("MorbidityTestName");
				MorbidityMarkerRef = xl.get(i).get("MorbidityMarkerRef");
				MorbidityTestUnit = xl.get(i).get("MorbidityTestUnit");
	         
				if (MorbidityName != null && !MorbidityName.isEmpty()) {
					
					Map<String,Object> lMap = new HashMap<String, Object>();
					
					lMap.put("MorbidityName", MorbidityName);
					lMap.put("MorbidityTestName", MorbidityTestName);
					lMap.put("MorbidityMarkerRef", MorbidityMarkerRef);
					lMap.put("MorbidityTestUnit", MorbidityTestUnit);

					jsonArrayPayload.add(lMap);
				}
				
			}
		
			for(int a =0; a< jsonArrayPayload.size();) {
		
				List<Map<String, Object>> payLoad = new ArrayList<Map<String,Object>>();
				
				for(int c = 0; c < (triggerCount); c++) {
					
			        payLoad.add(jsonArrayPayload.get(a));
					
					if(c == (triggerCount)) {
					String BatchPayload = payLoad.toString();
					response= (Response) given().log().all().spec(requestSpecification()).body(BatchPayload).when().post(resourceAPI.getResource());
								
					
					}else if( a == jsonArrayPayload.size()-1) {
						
						String RequestBody = payLoad.toString();
						
						response = (Response) given().log().all().spec(requestSpecification()).body(RequestBody).when().post(resourceAPI.getResource());
								
						a++;
						break;
					}
					a++;
					
				}
				
			}
			
		}

	
	
}
