package Resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtility
{

	public static String getScreenShot(WebDriver driver, String stepName) throws IOException
	{
		try {
			// Create Screenshots directory if it doesn't exist
			String screenshotsPath = System.getProperty("user.dir") + "\\Screenshots";
			File screenshotsDir = new File(screenshotsPath);
			if (!screenshotsDir.exists()) {
				screenshotsDir.mkdirs();
			}
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			// Clean step name to create valid filename
			String cleanStepName = stepName.replaceAll("[^a-zA-Z0-9_-]", "_");
			String destinationPath = screenshotsPath + "\\" + cleanStepName + ".png";
			
			File destination = new File(destinationPath);
			FileUtils.copyFile(source, destination);
			return destinationPath;
		} catch (Exception e) {
			System.err.println("Error taking screenshot: " + e.getMessage());
			return null;
		}
	}
}
