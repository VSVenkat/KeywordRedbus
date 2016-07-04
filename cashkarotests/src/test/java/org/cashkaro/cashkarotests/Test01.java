package org.cashkaro.cashkarotests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test01 extends BaseTest {
	
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver = getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://Cashkaro.iamsavings.co.uk");
	}

	@Test(priority=1)
	public void JoinCashKaroFree() throws InterruptedException
	{
		JoinPage jp = new JoinPage(driver);
		jp.JoinFree();
		RegistrationPage rp = new RegistrationPage(driver);
		rp.registerUser();
		System.out.println(driver.getTitle());
	}
	
	@Test(priority=2)
	public void SignInAsNewUser()
	{
		JoinPage jp = new JoinPage(driver);
		jp.SignIn();
		SignInPage sp = new SignInPage(driver);
		sp.SignIn();
		System.out.println(driver.getTitle());

	}
	
	@Test(priority=3)
	public void JoinUsingFacebookAccount()
	{
		JoinPage jp = new JoinPage(driver);
		jp.JoinFree();
		jp.clickJoinWithFacebook();
		jp.switchtofacebookWindow();
		jp.enterEmailID();
		jp.enterPassword();
		jp.clickLogin();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Facebook");
		
	}
	
	@Test(priority=4)
	public void forgotPassword()
	{
		JoinPage jp = new JoinPage(driver);
		jp.SignIn();
		SignInPage sp = new SignInPage(driver);
		sp.retrievePassword();
		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Password sent!')]")).getText(), "Password sent!");
	}
		

}
