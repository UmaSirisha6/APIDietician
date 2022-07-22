package utility;

import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import resources.Base;

import java.io.IOException;

public class ExcelUtil {
	
	
	public static ExcelReader reader;
	

	public static Map<String, String> getxlData(String SheetName) {
		
			
		reader = new ExcelReader();
		//*********   data from excel  **********  //
		System.out.println("Reading excel");
		Map<String, String> data = null;
		try {
			data = 	reader.getData(Base.getGlobalValue("ExcelFilePath"), SheetName).get(0);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		 return data;
		}
	

}
