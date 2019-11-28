package io.learning.listner;



import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

import io.learning.testcases.Login;


public class ReportListner extends Login implements ITestListener{
	//Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ExtentTest logger;
    private static ExtentTest parentTest;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    
    
	public synchronized void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
		//System.out.println((result.getMethod().getMethodName() + " started!"));
       ExtentTest childTest = parentTest.createNode(result.getMethod().getMethodName(),result.getMethod().getDescription());
        //childTest.assignCategory("TestSetp");
        test.set(childTest);
    }
 
    
    public synchronized void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
		try {
			//MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(cm.takeScreenShot(result.getName())).build();
			if(result.getName().equalsIgnoreCase("KillApp")) {
				test.get().pass("Test Step: "+ result.getName());
			}
			else {
				MediaEntityModelProvider mediaModel =  MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\GSingh\\Downloads\\BE\\validateSignIn_23-Jan-2019__06_03_22PM.png").build();
		        test.get().pass("Test Case# "+ result.getName(), mediaModel);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //test.get().log(Status.PASS, MarkupHelper.createLabel(result.getTestName() + " Test Case PASSED", ExtentColor.GREEN));
    }
 
    
	public synchronized void onTestFailure(ITestResult result) {
		try {
			//System.out.println((result.getMethod().getMethodName() + " failed!"));
	        //cm.takeScreenShot(result.getName());// .capture(result.getName());
	        
	        //adding screenshots to log
	        MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\GSingh\\Downloads\\BE\\validateSignIn_23-Jan-2019__06_03_22PM.png").build();
	        //MediaEntityModelProvider mediaModel =  MediaEntityBuilder.createScreenCaptureFromPath("C:\\Testcases\\screenshots\\validateSignIn_23-Jan-2019__06_03_22PM.png").build();
	          StringWriter sw = new StringWriter(); 
	          result.getThrowable().printStackTrace(new PrintWriter(sw));
	          String stacktrace = sw.toString(); 
	          test.get().fail("<span class='label failure'>" +"Test Case# "+ result.getName() + "</span>"+  "<pre>Stacktrace:\n" + stacktrace + "</pre>", mediaModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
    
    public synchronized void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
    	//System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
 }
 
    
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    	//System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
 
    
    public synchronized void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    	System.out.println("Test Case started!");
    	// creating nodes	
    	parentTest = extent.createTest("UseCase# " +context.getName(), context.getHost());
    	//parentTest.assignCategory("TestCase");
    	test.set(parentTest);

    }
 
    
    public synchronized void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
    	 System.out.println(("Test Case is ending!"));
         extent.flush();
         
         /*public synchronized static ExtentReports getInstance() {
             if (extent == null) {
                 if (context != null) {
                     File outputDirectory = new File(context.getOutputDirectory());
                     File resultDirectory = new File(outputDirectory.getParentFile(), "html");
                     extent = new ExtentReports(resultDirectory + File.separator +  "index.html", true);
                     File configFile = new File("src/test/resources/extent-config.xml");
                     extent.loadConfig(configFile);
                     Reporter.log("Extent Report directory: " + resultDirectory, true);
                 }
             }
             return extent;
         }*/
 
    }



}
