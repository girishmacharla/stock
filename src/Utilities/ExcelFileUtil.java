  package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;



public class ExcelFileUtil {
    Workbook wb;
    //to read excel path
    
public ExcelFileUtil()throws Throwable
{
	FileInputStream fis =new FileInputStream("C:\\mrng930batch\\ERP_Stock\\TestInput\\InputSheet.xlsx");
	wb=WorkbookFactory.create(fis);	
}
//count no rows
public int rowcount(String Sheetname)
{
	return wb.getSheet(Sheetname).getLastRowNum();
}
public int colcount(String sheetname)
{
   return wb.getSheet(sheetname).getRow(0).getLastCellNum();
   
}

public String getData(String sheetname,int row,int column)

{
	String data="";
	if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC) 
	{
		int celldata=(int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
		
	//convert cell data in string
		data = String.valueOf(celldata);
	}
	else {
		data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
	}
	return data;
}

public void setCellData(String sheetname,int row,int column, String status)throws Throwable{
	
	//get sheet from wb
	Sheet ws=wb.getSheet(sheetname);
	//get row from sheet
	Row rownum=ws.getRow(row);
	
	//Create cell in row
		 Cell cell=rownum.createCell(column);
		 //write status into cell
		 cell.setCellValue(status);
		 if(status.equalsIgnoreCase("Pass"))
		 {
			 //create a cell style.
			 CellStyle style=wb.createCellStyle();
			 //create a font
			 Font font=wb.createFont();
			 //apply color to the text
			 font.setColor(IndexedColors.GREEN.getIndex());
			 //apply bold to the text
			 font.setBold(true);
			 //set font
			 style.setFont(font);
			 //set cell style
			 rownum.getCell(column).setCellStyle(style);
		 }
		 else if(status.equalsIgnoreCase("Fail"))
		 {
			 CellStyle style=wb.createCellStyle();
			 //create a font
			 Font font=wb.createFont();
			 //apply color to the text
			 font.setColor(IndexedColors.RED.getIndex());
			 //apply bold to the text
			 font.setBold(true);
			 //set font
			 style.setFont(font);
			 //set cell style
			 rownum.getCell(column).setCellStyle(style);
		 } 
		 else if(status.equalsIgnoreCase("Not Executed"))
		 {
			 CellStyle style=wb.createCellStyle();
			 //create a font
			 Font font=wb.createFont();
			 //apply color to the text
			 font.setColor(IndexedColors.BLUE.getIndex());
			 //apply bold to the text
			 font.setBold(true);
			 //set font
			 style.setFont(font);
			 //set cell style
			 rownum.getCell(column).setCellStyle(style);
			 
		 }
		 FileOutputStream fos=new FileOutputStream("C:\\mrng930batch\\ERP_Stock\\TestOutput\\hybrid1.xlsx");
		 wb.write(fos);
		 fos.close();
		 //wb.close();
		 
		 }
	 }