package com.MyTests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import datatable.Xls_Reader;

public class ExecutionFile {
	
	public static void executeMethods(String methodName, Object... inputs) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		
			Class<?> params[] = new Class[inputs.length];
			for(int i=0;i<inputs.length;i++)
			{
				if (inputs[i] instanceof String) 
				{
					params[i]= String.class;
				}
			}
			
			Class<?> cls = Class.forName("com.MyTests.AllTests");
			Object ins = cls.newInstance();
			Method meth = cls.getDeclaredMethod(methodName, params);
			meth.invoke(ins, inputs);
	}
	
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		ExecutionFile ef = new ExecutionFile();
		Xls_Reader excel = new Xls_Reader("MyData.xlsx");
		for(int i=2;i<=excel.getRowCount("MyTests");i++)
		{
			List<Object> myParamList = new ArrayList<Object>();
			String methodName=excel.getCellData("MyTests", "Keywords", i);
			for(int j=1;j<excel.getColumnCount("MyTests");j++)
			{
				

					myParamList.add(excel.getCellData("MyTests", j, i));
			}
			
			Object[] paramListObject = new String[myParamList.size()];
			paramListObject = myParamList.toArray(paramListObject);
			ef.executeMethods(methodName, paramListObject);
		}

	}

}
