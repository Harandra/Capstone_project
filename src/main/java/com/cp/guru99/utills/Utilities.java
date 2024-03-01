package com.cp.guru99.utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	public static boolean validateTitle(WebDriver driver, String Expected_Title) {
		boolean result = false;
		String Actual_Title = driver.getTitle();
		result = Actual_Title.equals(Expected_Title);
		return result;
	}

	public static boolean CheckElementPresence(WebDriver driver, WebElement Element, int i) {
		boolean result = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
			wait.until(ExpectedConditions.visibilityOf(Element));
		} catch (Exception e) {
			result = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	public static String[][] supplyData(String sheetname) {
	    File excelFile = new File(
	            System.getProperty("user.dir") + "\\src\\main\\java\\com\\cp\\guru99\\testdata\\testdata.xlsx");
	    XSSFWorkbook workbook = null;
	    FileInputStream fis;
	    try {
	        fis = new FileInputStream(excelFile);
	        workbook = new XSSFWorkbook(fis);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    XSSFSheet sheet = workbook.getSheet(sheetname);
	    int rows = sheet.getLastRowNum();
	    int cols = sheet.getRow(0).getLastCellNum();
	    String[][] data = new String[rows][cols];
	    for (int i = 1; i <= rows; i++) {
	        XSSFRow row = sheet.getRow(i);

	        for (int j = 0; j < cols; j++) {
	            XSSFCell cell = row.getCell(j);

	            CellType celltype = cell.getCellType();

	            switch (celltype) {
	                case STRING:
	                    data[i - 1][j] = cell.getStringCellValue();
	                    break;

	                case NUMERIC:
	                    data[i - 1][j] = Integer.toString((int) cell.getNumericCellValue());
	                    break;

	                case BOOLEAN:
	                    data[i - 1][j] = cell.getStringCellValue();
	                    break;

	                default:
	                    break;
	            }
	        }
	    }
	    return data;
	}
}
