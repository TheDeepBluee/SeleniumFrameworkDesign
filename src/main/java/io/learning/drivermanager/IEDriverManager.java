package io.learning.drivermanager;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEDriverManager extends DriverManager{
	
	public static String filePath = "C:\\IEDriverServer.exe";

	@Override
	protected void createWebDriver() {
		
		System.setProperty("webdriver.ie.driver", filePath);
		InternetExplorerOptions options= new InternetExplorerOptions();
		this.driver=new InternetExplorerDriver(options);
		
	}

}
