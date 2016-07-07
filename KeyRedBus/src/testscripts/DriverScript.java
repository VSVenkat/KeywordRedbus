package testscripts;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import datatable.ReadExcel;
import datatable.Xls_Reader;
import jxl.read.biff.BiffException;

public class DriverScript {
	
	public void runReflection(String className, String methodNames, Object... inputArgs) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		
		Class<?> params[] = new Class[inputArgs.length];

		for (int i = 0; i < inputArgs.length; i++) {
			if (inputArgs[i] instanceof String) {
				params[i] = String.class;
				//System.out.println(params[i]);
			}
		}
		
		Class<?> c = Class.forName(className);
		Object instance = c.newInstance();
		Method myMethod = c.getDeclaredMethod(methodNames, params);
		myMethod.invoke(instance, inputArgs);
		
	}
	public static void main(String args[]) throws BiffException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		DriverScript driverScript = new DriverScript();
		Xls_Reader readExcel = new Xls_Reader("D:/newworkspace/KeyRedBus/Driver-DB.xlsx");
		Xls_Reader readData = new Xls_Reader("D:/newworkspace/KeyRedBus/TestData.xlsm");
		for(int i=2;i<readExcel.getRowCount("Keywords");i++)
		{
			List<Object> myParamList = new ArrayList<Object>();
			String methodName = readExcel.getCellData("Keywords", "Keyword", i);
			String screenname = readExcel.getCellData("Keywords", "ScreenName", i);
			String databinding = readExcel.getCellData("Keywords", "DataBinding", i);
			for(int j=2;j<=readData.getRowCount(screenname);j++)
			{
				for(int k=0;k<readData.getColumnCount(screenname);k++)
				{
					if(databinding.equals(readData.getCellData(screenname, "DataBinding", j)))
						
					{
						//System.out.println(readData.getCellData(screenname, k, j));
						myParamList.add(readData.getCellData(screenname, k, j));
					}
				}
			}
			
			Object[] paramListObject = new String[myParamList.size()];
			paramListObject = myParamList.toArray(paramListObject);
			driverScript.runReflection("testscripts.Functions", methodName, paramListObject);
		}
	}
}
