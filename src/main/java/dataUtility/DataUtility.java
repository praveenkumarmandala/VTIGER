package dataUtility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {
	
	public String propertfileData(String data) throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Acer\\QSPSeleniumIntro\\Vtiger\\src\\main\\resources\\credential.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(data);		
	}
	
	public String excelData(String sheetname,int rownum, int cellnum) throws Exception, IOException
	{
		FileInputStream fis = new FileInputStream("D:\\login.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		Row r = sh.getRow(rownum);
		Cell c = r.getCell(cellnum);
		DataFormatter df = new DataFormatter();
		String data = df.formatCellValue(c);
		return data;
		
	}
}
