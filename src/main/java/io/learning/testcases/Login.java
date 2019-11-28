package io.learning.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.learning.drivermanager.DriverManager;
import io.learning.drivermanager.DriverManagerFactory;
import io.learning.drivermanager.DriverType;


public class Login {
	
	DriverManager driverManager;
	
	WebDriver driver;
	
	public void ChromeLogin() {
	
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		driver.navigate().to("https://blueeye-qa.jetblue.com");
	
	}
	
	@Test
	public void IELogin() {
		
		driverManager = DriverManagerFactory.getDriverManager(DriverType.IE);
		driver = driverManager.getWebDriver();
		driver.navigate().to("https://blueeye-qa.jetblue.com");
		
		}
		
}


