package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	public static String getDataFromExcel(String sheet,int row,int cell ) throws EncryptedDocumentException, IOException
	{
		//excel sheet code
		String data="";
		String path ="C:\\Users\\admin\\eclipse-workspace\\DemoLogin\\src\\main\\resources\\LoginTestData.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook wb= WorkbookFactory.create(file);
		Sheet sheet1 = wb.getSheet("Sheet1");
		Row row1  = sheet1.getRow(row);
		Cell cell1 =row1.getCell(cell);


		String data1 = cell1.getStringCellValue();
		System.out.println(data1);
		return data1;
	}
}
