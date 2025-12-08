package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager
{

	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if (extent ==null)
		{
			createInstance();
		}
		return extent;
		
	}
	
	public static ExtentReports createInstance()
	{
		String reportPath = System.getProperty("user.dir")+"\\ExtentReports\\ExtentReport.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setReportName("NopCommerce Automation Test Results");
		sparkReporter.config().setDocumentTitle("NopCommerce Test Results");
		
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Tester", "Pradeep Garikimukku");
	
		return extent;
		
	}
}
