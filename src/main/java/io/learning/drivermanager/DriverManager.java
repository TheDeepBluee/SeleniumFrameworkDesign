package io.learning.drivermanager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	
	protected WebDriver driver;
	
	protected  abstract void createWebDriver();
	
	public void quitWebDriver(){
		
		if(driver!=null){
			driver.quit();
		}
		
	}

	public WebDriver getWebDriver(){
		if(driver==null){
			createWebDriver();
		}
		
		return driver;
	}
	
}
