package testUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseclass.BaseTest;

public class Listenerstest extends BaseTest implements ITestListener{

	ExtentsReporter e = new ExtentsReporter();
	ExtentTest test;
	ExtentReports extent;
	 
	  public void onTestStart(ITestResult result)
	  {
		  extent = e.getReportObj();
		  test = extent.createTest(result.getMethod().getMethodName());
		  
	  }

	  public  void onTestSuccess(ITestResult result) 
	  {
		  test.log(Status.PASS, "Test Passed");
		   
	  }

		 
	  public void onTestFailure(ITestResult result) 
	  {
		   test.fail(result.getThrowable());
		   String methodname = result.getMethod().getMethodName();
		   TakesScreenshot ts = (TakesScreenshot)driver;
		   File src = ts.getScreenshotAs(OutputType.FILE);
		   File dest = new File(".\\screenshot\\"+methodname+".png");
		   try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	  public  void onTestSkipped(ITestResult result) 
	  {
		  test.log(Status.SKIP, result.getMethod().getMethodName()+".... is skipped");
		  
	  }

	  public void onFinish(ITestContext context) 
	  {
		  extent.flush();  
	  }

}
