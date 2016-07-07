package datatable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {
	
	FileInputStream fis;
	Workbook workbook;
	Sheet sheet;
	
	public void openExcel(String filePath) throws BiffException, IOException
	{

		
		fis = new FileInputStream(filePath);
		workbook = Workbook.getWorkbook(fis);
		sheet = workbook.getSheet(0);
	}
	
	public int getRowCount()
	{
		return sheet.getRows();
	}
	public int getColumnCount()
	{
		return sheet.getColumns();
	}
	public String getCellValue(int iCol, int iRow)
	{
		return sheet.getCell(iCol, iRow).getContents();
	}

}
