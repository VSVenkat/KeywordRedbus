/*
 * Author : Venkat Rao
 * Author email: Venkat.vallam@gmail.com
 * Date : 23-06-2016
 * 
 * 
 */

package org.cashkaro.cashkarotests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JoinPage {
	
	WebDriver driver;
	By joinlink = By.linkText("JOIN FREE");
	By signIn = By.linkText("SIGN IN");
	By facebookBtn = By.id("close_and_go_fb");
	By username = By.id("email");
	By password = By.id("pass");
	File f = null;
	Properties p = null;
	FileInputStream fis=null;
	
	JoinPage(WebDriver driver)
	{
		this.driver = driver;
		try {
			f= new File("D:/newworkspace/cashkarotests/Data.properties");
			fis = new FileInputStream(f);
			p= new Properties();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			p.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	//To click on the Join Free link on the home page
	public void JoinFree()
	{
		clickLink(joinlink);
	}
	
	//to click on the sign in link
	public void SignIn()
	{
		clickLink(signIn);
	}
	
	//Generic function to click link
	public void clickLink(By link)
	{
		driver.findElement(link).click();
	}
	
	//to click join facebook button
	
	public void clickJoinWithFacebook()
	{
		driver.findElement(facebookBtn).click();
	}

	//swithing to the facebook pop up window
	public void switchtofacebookWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		
		Iterator<String> i1 = s1.iterator();
		while(i1.hasNext())
		{
			String childWindow = i1.next();
			if(!parentWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				System.out.println(driver.getTitle());

			}
			
		}
		//driver.switchTo().window(parentWindow);

		
	}

	//entering facebook email id
	public void enterEmailID() {
		driver.findElement(username).sendKeys(p.getProperty("facebookID"));
		
	}

	//enter facebook password
	public void enterPassword() {
		driver.findElement(password).sendKeys(p.getProperty("facebookPass"));
		
	}

	//click on submit
	public void clickLogin() {
		driver.findElement(password).submit();
		
	}

}
