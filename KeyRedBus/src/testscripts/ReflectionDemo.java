package testscripts;

import java.lang.reflect.Method;

public class ReflectionDemo {
	
	public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException
	{
		Class<?> c = Class.forName("testscripts.ReflectionTestDemo");
		Method m = c.getDeclaredMethod("demo", null);
		System.out.println(m.toString());
		
		Method m1 = c.getDeclaredMethod("test2", String.class);
		System.out.println(m1.toString());
		
		//int n[] = new int[5];
		Class<?> n[] = new Class[2];
		n[0] = String.class;
		n[1] = Integer.class;
		
		Method m2 = c.getDeclaredMethod("test3", n);
		
	}
	
	
		

	
	

}
