package com.training.dataproviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
		//	obj[2] = temp.getsubject(); 
			//obj[3] = temp.getmessage(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\SUHASINIPOKKALLA\\git\\SPB14\\final-framework-testng\\target\\Test2.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		
	//	Object[][] arrayObject = getExcelData("C:\\Users\\SUHASINIPOKKALLA\\git\\SPB14\\final-framework-testng\\target\\Test.xls", "Sheet1");
		return new ReadExcel().getExcelData("C:\\Users\\SUHASINIPOKKALLA\\git\\SPB14\\final-framework-testng\\target\\Test.xlsx","Sheet1");
		
	}
	
	@DataProvider(name = "loginData")
	public Object[][] loginData(){
		// ensure you will have the title as first line in the file 
		String fileName ="C:\\Users\\SUHASINIPOKKALLA\\git\\SPB14\\final-framework-testng\\target\\Test.xls"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	/*
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
		//	Workbook wb = Workbook.getWorkbook(fs);
		//	Sheet sh = wb.getSheet("sheetName");
			XSSFWorkbook wb= new XSSFWorkbook(new FileInputStream("fileName"));
			XSSFSheet sh=wb.getSheet("sheetName");


			int totalNoOfCols = sh.getRow(0).getLastCellNum();
			int totalNoOfRows = sh.getPhysicalNumberOfRows();
					
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue(); 
					
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} 
		
		return arrayExcelData;
	}
 */
}
