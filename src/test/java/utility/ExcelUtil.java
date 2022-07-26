package utility;

import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import resources.Base;

import java.io.IOException;

public class ExcelUtil {
	
	
	public static ExcelReader reader;
	
	public static List<Map<String,String>> getxlData(String sheetName) {
		
		
		reader = new ExcelReader();
		//*********   data from excel  **********  //
		System.out.println("Reading excel");
		List<Map<String,String>> data = null;
		try {
			data = 	reader.getData(Base.getGlobalValue("ExcelFilePath"), sheetName);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		 return data;
		}
	

}
