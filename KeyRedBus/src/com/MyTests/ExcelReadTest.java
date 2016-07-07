package com.MyTests;

import datatable.Xls_Reader;

public class ExcelReadTest {
	
	public static void main(String args[])
	{
		Xls_Reader excel = new Xls_Reader("MyData.xlsx");
		System.out.println(excel.getRowCount("MyTests"));
		for(int i=2;i<=excel.getRowCount("MyTests");i++)
		{
			System.out.println(excel.getCellData("MyTests", "Keywords", i));
			
			for(int j=1;j<excel.getColumnCount("MyTests");j++)
			{
				System.out.println("             "+excel.getCellData("MyTests", j, i));
			}
		}
	}

}
