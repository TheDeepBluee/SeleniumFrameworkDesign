package io.learning.drivermanager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{
	
	public static String filePath = "C:\\chromedriver.exe";

	@Override
	protected void createWebDriver() {
		
		System.setProperty("webdriver.chrome.driver", filePath);
		ChromeOptions options= new ChromeOptions();
		options.addArguments("disable-infobars"); 
		this.driver=new ChromeDriver(options);
		
	}

}
