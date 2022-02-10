/**
 * 
 */
package TestNGPractice.E2ETesting;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * @author DELL
 * 
 * ITestListener for screenshots on failure
 * 
 * on testNG version greater than 7, you wont see all implement methods under Listeners class,
 * you need to go to class Listeners -> right click -> source -> override/implement methods -> select all methods under ITestListener
 *
 */
public class Listeners extends base implements ITestListener {
	ExtentReports extent = ExtentReporterNG.getReportObjec();
	ExtentTest test;

	//Making thread safe for parallel execution using Extent report ThreadLocal class
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		//Adding Extent report feature
		//test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		//Failure Log without ThreadLocal class for sequential execution
		//test.fail(result.getThrowable());
		
		//Failure Log with ThreadLocal class for parallel execution
		extentTest.get().fail(result.getThrowable());
		
		//Screenshots on failure
		
		WebDriver driver = null;
		
		String testMethodName = result.getMethod().getMethodName();
		
		//There is already a long method exist to take screenshots on failure
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		//You need not require all catch blocks
		//Consider one generic catch block
		
		/*catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		try {
			
			//ThreadLocal class for parallel execution
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), result.getMethod().getMethodName());
			
			//When sequential execution without ThreadLocal class 
			//getScreenShotPath(testMethodName, driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		//Adding Extent report feature
		test = extent.createTest(result.getMethod().getMethodName());
		
		//Extent report for Parallel execution using ThreadLocal class
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		//Pass Log without ThreadLocal class for sequential execution
		//test.log(Status.PASS, "Test Passed");
		
		//Pass Log with ThreadLocal class for parallel execution
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}
	
	

}
