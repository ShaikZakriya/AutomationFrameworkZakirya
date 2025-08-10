package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

static HashMap<String, String> map = null;
	
	public static HashMap <String, String> getExcelData(String sheetName,String tcID) throws IOException {
	    
			
				
			
		     map = new HashMap<String, String>();
		     
		     String path = System.getProperty("user.dir")+"//src//TestData/TestData.xlsx";
		     FileInputStream fis = new FileInputStream(path);
		     
		     XSSFWorkbook workbook = new XSSFWorkbook(fis);
		     XSSFSheet sheet = workbook.getSheet(sheetName);
		     
		     int lastRowCount = sheet.getLastRowNum();
		     
		     for(int i=0; i<lastRowCount; i=i+2)
		     {
		    	 String temp = sheet.getRow(i).getCell(0).getStringCellValue();
		    	 if(temp.equalsIgnoreCase(tcID))
		    			 {
		    		         XSSFRow targetkeyRow = sheet.getRow(i);
		    		         XSSFRow targetValueRow = sheet.getRow(i + 1);
		    		         int lastColumn = targetkeyRow.getLastCellNum();
		    		         for(int j =1; j<lastColumn-1; j++)
		    		     {    
		    		         String ktemp = targetkeyRow.getCell(j).getStringCellValue();
		    		         
		    		         String k = ktemp.replaceAll("\"","");
		    		         String vTemp = targetValueRow.getCell(j).getStringCellValue();
		    		         String v = vTemp.replaceAll("\"", "");
		    		         map.put(ktemp, vTemp);
		    		         		
		    			 }
    }
		     
		     
		     
		 }
		 	//System.out.println(map.keySet());
		     return map;
			
		
	
      }
	
}
