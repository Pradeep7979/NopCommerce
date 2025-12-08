package Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Resources.ExtentReportManager;
import Resources.ExtentTestManager;

public class Listeners  extends BaseTest implements ITestListener
{
			ExtentReports extent = ExtentReportManager.getInstance();

			@Override
	    public void onTestStart(ITestResult result) {
				 String testName = result.getMethod().getMethodName();
	        ExtentTestManager.startTest(testName, "Starting test: " + testName);	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test Passed");

	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	ExtentTestManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());
	    	
	   // Take screenshot on failure
        Object currentClass = result.getInstance();
        BaseTest base = (BaseTest) currentClass;

        String screenshotPath =null;
				try
				{
					screenshotPath = getScreenShot(base.driver, "TestFailure");
				} catch (IOException e)
				{
					e.printStackTrace();
				}

        try 
        {
            ExtentTestManager.getTest().fail("Screenshot on Failure:",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()
            );
        } 
        catch (Exception e) 
        {
            ExtentTestManager.getTest().fail("Screenshot attach failed: " + e.getMessage());     
        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");

	    }

	    @Override
	    public void onFinish(ITestContext context) {
	    	extent.flush();
	    }
	}


