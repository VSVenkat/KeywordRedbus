package org.cashkaro.cashkarotests;

import static java.util.Arrays.asList;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;


public class BaseTest {
	
	WebDriver driver;
	public void setDriver(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
    			driver = new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "C:/Drive-C/softwares/selenium/chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	
	public WebDriver getDriver()
	{
		setDriver("chrome");
		return driver;
	}
	
	@DataProvider(name = "data")
    public Object [][] data() {
        return new Object[][] {
                
        };
    }

}
