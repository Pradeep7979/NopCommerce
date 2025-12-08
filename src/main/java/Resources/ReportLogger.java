package Resources;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;


public class ReportLogger extends ScreenShotUtility {

    public static void logStepWithScreenshot(String message, WebDriver driver) throws IOException {
        String screenshotPath = null;
        try {
            screenshotPath = getScreenShot(driver, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ExtentTest test = ExtentTestManager.getTest();

        if (test != null) {
            try {
                if (screenshotPath != null && !screenshotPath.isEmpty()) {
                    test.info(
                        message,
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()
                    );
                } else {
                    test.info(message + " (screenshot not available)");
                }
            } catch (Exception e) {
                test.info(message + " (screenshot attach failed: " + e.getMessage() + ")");
            }
        }
    }
}
