package testscripts;

public class KeywordFramesTest {
	
	public void login(String username, String password, String age)
	{
		System.out.println("user name is "+username);
		System.out.println("password is "+password);
		System.out.println("age is "+age);
	}

	public void add(String a, String b)
	{
		int x = Integer.parseInt(a);
		int y = Integer.parseInt(b);
		System.out.println(x+y);
	}
}
