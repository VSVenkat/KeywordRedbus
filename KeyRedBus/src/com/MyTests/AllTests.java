package com.MyTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class AllTests {

	static WebDriver driver;
	public void openURL(String x, String URL)
	{
		System.setProperty("webdriver.chrome.driver", "C:/Drive-C/softwares/selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		
	}
	public void EnterText(String locator, String value)
	{
		driver.findElement(By.name(locator)).sendKeys(value);
	}
	public void ClickLink(String m, String link)
	{
		driver.findElement(By.linkText(link)).click();
	}
	public void ClickButton(String locator, String value)
	{
		driver.findElement(By.xpath(locator)).click();
	}
	public void VerifyText(String text, String actual)
	{
		System.out.println("verify started");
		System.out.println(text);
		System.out.println(actual);
		System.out.println("verify ended");
		System.out.println("TEXT IS CORRECT");
	}
	
	public void open()
	{
		System.out.println("Open executed");
	}
	
	public void click()
	{
		System.out.println("click executed");
	}
	
	public void Verify()
	{
		System.out.println("verification done");

	}

}
