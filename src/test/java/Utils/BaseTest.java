package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest
{
	public LoginPage loginPage;
	 public  WebDriver driver;
	public WebDriver initializeDriver() throws IOException
	{
		Properties nop  = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\nop.properties");
	  nop.load(fis);
		String BrowserName = nop.getProperty("browser");
		
		if (BrowserName.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
	}
		
		else if (BrowserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "edge.exe");
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public static String getScreenShot(WebDriver driver, String stepName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\Screenshots\\"+stepName+".png"));
		return System.getProperty("user.dir")+"\\Screenshots\\"+stepName+".png";
		
	}
	
	@BeforeMethod
	public LoginPage launchApplication() throws IOException
	{
		
		 driver =initializeDriver();
		loginPage = new LoginPage(driver);
		loginPage.Goto();
		return loginPage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
