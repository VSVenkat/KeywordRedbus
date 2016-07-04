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
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	
	WebDriver driver;
	By username = By.id("uname");
	By passtxt = By.id("pwd-txt");
	By pass = By.id("pwd");
	By signinBtn = By.id("sign_in");
	By forgotpass = By.linkText("Forgot Password?");
	By forgotPassInput = By.id("from_email");
	By forgotPassBtn = By.linkText("Submit Request");
	File f = null;
	Properties p = null;
	FileInputStream fis=null;
	SignInPage(WebDriver driver)
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

	//switching to the iframe
	public void SwitchWindow()
	{
		
		driver.switchTo().frame(driver.findElement(By.className("cboxIframe")));
		
		
	}
	
	
	//user signing into the account
	public void SignIn()
	{
		SwitchWindow();
		driver.findElement(username).sendKeys(p.getProperty("emailid"));
		driver.findElement(passtxt).click();
		driver.findElement(pass).sendKeys(p.getProperty("password"));
		driver.findElement(signinBtn).click();
	}
	
	//user clicking the forgot password and providing the email id 
	//where the user is intending to receive the password  
	public void retrievePassword()
	{
		SwitchWindow();
		driver.findElement(forgotpass).click();
		driver.findElement(forgotPassInput).sendKeys(p.getProperty("emailid"));
		driver.findElement(forgotPassBtn).click();
	}

}
