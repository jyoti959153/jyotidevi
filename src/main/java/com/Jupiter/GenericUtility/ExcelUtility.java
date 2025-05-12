  

package com.Jupiter.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream("./src/test/resources/Vdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	wb.close();
	return data;
	}
	
	public void writedataBacktoExcel(String sheetname,int row,int cell,String data) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream("./src/test/resources/Vdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(sheetname);
	Row r = sheet.getRow(row);
	r.createCell(cell,CellType.STRING);
	
	
	FileOutputStream fos=new FileOutputStream("./src/test/resources/Vdata.xlsx");
	wb.write(fos);
	wb.close();
	}

	public int getRowcount(String sheetname) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream("./src/test/resources/Vdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	int rowcount = wb.getSheet(sheetname).getLastRowNum();
	wb.close();
	return rowcount;
	}

}
