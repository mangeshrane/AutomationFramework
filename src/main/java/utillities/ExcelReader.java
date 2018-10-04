/*package utillities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReader {
	private String excelPath = "";
	public ExcelReader(String excelPath) {
		this.excelPath = excelPath;
	}
	
	public void getSheet(String sheetName) {
	Workbook workbook;
	if (excelPath.endsWith("xls")) {	
	workbook= new HSSFWorkbook(new FileInputStream(new File("filename.xls")));
	}else {
	workbook = new XSSFWorkbook
	}
	Sheet sheet = workbook.getSheet("RequestData");
	}
	
	
	int lastRow = sheet.getLastRowNum();
	System.out.println(lastRow);
	int max = 0;
	for(int i=0; i<lastRow; i++) {
		if(sheet.getRow(i).getLastCellNum() > max) { 
			max = sheet.getRow(i).getLastCellNum();
		}
	}
	
	System.out.println(max);
	
	List<String> keys = new LinkedList<String>();
	// getting header fields
	for(int i=0; i< sheet.getRow(1).getLastCellNum(); i++) {
		keys.add(sheet.getRow(1).getCell(i).toString());
	}
	
	String filter = "keyword";
	List<List<String>> rawData = new ArrayList<List<String>>();
	for( int j=3; j< sheet.getLastRowNum(); j++) {
		if(sheet.getRow(j).getCell(0).toString().equalsIgnoreCase(filter)) {
			List<String> fields = new ArrayList<String>();
			for(int k=0; k< sheet.getRow(j).getLastCellNum(); k++) {
				fields.add(sheet.getRow(j).getCell(k).toString());
			}
			if(!fields.isEmpty()) {
				rawData.add(fields);
			}
		}
	}
	
	HashMap<String, HashMap<String, String>> map = new HashMap<String, HashMap<String, String>>();

	for(List<String> a: rawData) {
		String Key = a.get(0) + a.get(1) + a.get(2);
		HashMap<String, String> request = new HashMap<String, String>();
		for(int i=0; i<keys.size(); i++) {
			request.put(keys.get(i), a.get(i));
		}
		map.put(Key.toLowerCase(), request);
	}
	
	System.out.println(map.toString());
}
}
*/