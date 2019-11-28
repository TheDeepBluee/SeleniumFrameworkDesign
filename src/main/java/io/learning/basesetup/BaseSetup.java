package io.learning.basesetup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

import io.learning.drivermanager.DriverManager;

public class BaseSetup {
	
	DriverManager driverManager;
	
	static WebDriver driver;
	
		
		  public static XSSFSheet ExcelWSheet;
	      public static XSSFWorkbook ExcelWBook;
	      public static XSSFCell Cell; 
	      public static XSSFRow row;
	      public static XSSFWorkbook wb;
	      protected static String Path = "C:\\Users\\GSingh\\Desktop\\BE_Users.xlsx";
		  protected static String SheetName = "Sheet1";
		
	     
		public static void setExcelFile(String Path,String SheetName) throws Exception 
		{
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		}

	//This method is to read the test data from the Excel cell
	//In this we are passing parameters/arguments as Row Num and Col Num
		public static String getCellData(int RowNum, int ColNum) throws Exception
		{
			DataFormatter formatter = new DataFormatter();
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = formatter.formatCellValue(Cell);
			return CellData;

		}
		
		public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
			try{
				row  = ExcelWSheet.getRow(RowNum);
				Cell = row.getCell(ColNum);

				if (Cell == null) {
					Cell = row.createCell(ColNum);
					Cell.setCellValue(Result);
				} else {
					Cell.setCellValue(Result);
				}
				// Constant variables Test Data path and Test Data file name
				FileOutputStream fileOut = new FileOutputStream(Path);
				ExcelWBook.write(fileOut);
				fileOut.flush();
				fileOut.close();
			}catch(Exception e){
				throw (e);
			}

		}
		
		public static void scrollTillElement(WebElement element) throws Exception{
			 
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); 
		}
		

}

