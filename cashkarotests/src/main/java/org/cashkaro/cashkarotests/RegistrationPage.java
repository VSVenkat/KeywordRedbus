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
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	
	WebDriver driver;
	By firstName = By.id("firstname");
	By emailID = By.id("email");
	By confermailID = By.id("con_email");
	By passtxt = By.id("pwd-txt");
	By passwordID = By.id("pwd");
	By tobeCheck = By.id("to_be_check");
	By joinfree = By.id("join_free_submit");
	By logoutLink = By.linkText("LOGOUT");
	File f = null;
	Properties p = null;
	FileInputStream fis=null;
	RegistrationPage(WebDriver driver)
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
	
	//Registering as a new user
	public void registerUser() throws InterruptedException
	{
		
		driver.findElement(firstName).sendKeys(p.getProperty("firstname"));
		driver.findElement(emailID).sendKeys(p.getProperty("emailid"));
		driver.findElement(confermailID).sendKeys(p.getProperty("emailid"));
		
		driver.findElement(passtxt).click();
		driver.findElement(passwordID).clear();
		driver.findElement(passwordID).sendKeys(p.getProperty("password"));
		
		Thread.sleep(60000);
		driver.findElement(joinfree).click();
		
		
	}

}
