/*
 * Author : Venkat Rao
 * Author email: Venkat.vallam@gmail.com
 * Date : 23-06-2016
 * 
 * 
 */

package org.cashkaro.cashkarotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MergeAccountPage {
	WebDriver driver;
	By link_AccountBtn = By.id("sign_in");
	
	MergeAccountPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	//verifying if the user has landed on the merge account page
	public void verifyExistenceOfLinkAccount()
	{
		if(driver.findElement(link_AccountBtn).isDisplayed())
		{
			System.out.println("Pass - User is on the Merge Account page");
		}
		else
		{
			System.out.println("Fail - User is not able to link the account page");
		}
	}
	
	public WebElement linaccountbutton()
	{
		if(driver.findElement(link_AccountBtn).isDisplayed())
		{
			return driver.findElement(link_AccountBtn);
		}
		else
		{
			return null;
		}
	}

}
