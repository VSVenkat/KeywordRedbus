package testscripts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import datatable.Xls_Reader;

public class ReadingXlsandInvokingMethods {
	
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		Xls_Reader xl = new Xls_Reader("D:/newworkspace/KeyRedBus/Driver-DB.xlsx");
		Xls_Reader testdata = new Xls_Reader("D:/newworkspace/KeyRedBus/TestData.xlsm");
		String keyword="";
		String screenname="";
		String databinding="";
		int cellno=0;
		List<Object> t = new ArrayList<Object>();
		for(int i=2;i<=xl.getRowCount("Keywords");i++)
		{
			keyword = xl.getCellData("Keywords", "Keyword", i);
			screenname = xl.getCellData("Keywords", "ScreenName", i);
			databinding = xl.getCellData("Keywords", "DataBinding", i);
			System.out.println(keyword);
			for(int j=1;j<testdata.getRowCount(screenname);j++)
			{
				cellno = testdata.getCellRowNum(screenname, "DataBinding", databinding);
			}
			for(int k=1;k<testdata.getColumnCount(screenname);k++)
			{
				t.add(testdata.getCellData(screenname, k, cellno));
			}
		}
		Object[] arr = new String[t.size()];
		arr = t.toArray(arr);
		/*for(int m=0;m<arr.length;m++)
		{
			System.out.println(arr[m]);
		}*/
		ReadingXlsandInvokingMethods r = new ReadingXlsandInvokingMethods();
		r.runReflection("testscripts.Functions", keyword, arr);
	}
	
	public void runReflection(String className, String methodNames, Object... inputArgs) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		Class<?> params[] = new Class[inputArgs.length];
		for (int i = 0; i < inputArgs.length; i++) {
			if (inputArgs[i] instanceof String) {
				params[i] = String.class;
			}
		}
		
		Class<?> c = Class.forName(className);
		Object instance = c.newInstance();
		Method myMethod = c.getDeclaredMethod(methodNames, params);
		myMethod.invoke(instance, inputArgs);
		
	}

}
