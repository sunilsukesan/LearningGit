package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;

public class ReadExcel {

	@DataProvider(name = "KoovsData")
	public Object [] [] readExcel() throws InvalidFormatException, IOException {
		
		XSSFWorkbook Workbook = new XSSFWorkbook(new File(".//src//test/resources//TestData.xlsx"));
		XSSFSheet sheet = Workbook.getSheetAt(0);
		
		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(0).getLastCellNum();
		Object [] [] data =  new Object  [rows] [columns];
		for (int i = 0; i <rows; i++) {
			for (int j = 0; j < columns; j++) {
				data [i] [j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		Workbook.close();
		return data;

	}

}
