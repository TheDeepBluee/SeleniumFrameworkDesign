package io.learning.testcaseexecution;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.learning.drivermanager.DriverManager;
import io.learning.drivermanager.DriverManagerFactory;
import io.learning.drivermanager.DriverType;
import io.learning.utilities.VideoRecorder;


public class Login {
	
	DriverManager driverManager;
	
	WebDriver driver;
	
	@Test
	public void ChromeLogin() throws Exception {
	
		VideoRecorder vr = new VideoRecorder();
		vr.startRecording();
		
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		driver.navigate().to("https://blueeye-qa.jetblue.com");
		Thread.sleep(5000);
		vr.stopRecording();
	}
	
	
	public void IELogin() {
		
		driverManager = DriverManagerFactory.getDriverManager(DriverType.IE);
		driver = driverManager.getWebDriver();
		driver.navigate().to("https://blueeye-qa.jetblue.com");
		
		}
		
}


