package testscripts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class KeywordFrames {
	
	public void reflection(String className, String methodName, Object... args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	
	{
		Class<?> params[] = new Class[args.length];
		for(int i=0;i<args.length;i++)
		{
			if(args[i] instanceof String)
			{
				params[i] = String.class;
			}
		}
		
		
		Class<?> c = Class.forName(className);
		Object i = c.newInstance();
		Method m = c.getDeclaredMethod(methodName, params);
		m.invoke(i, args);
		
	}
	
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		KeywordFrames k = new KeywordFrames();
		List<String> x = new ArrayList<String>();
		
		x.add("2");
		x.add("3");
		//x.add("15");
		String[] y = new String[x.size()];
		y = x.toArray(y);
		System.out.println(y.length);
		k.reflection("testscripts.KeywordFramesTest", "add", y);
	}

}
