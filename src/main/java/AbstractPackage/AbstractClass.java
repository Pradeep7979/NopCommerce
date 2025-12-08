package AbstractPackage;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass
{
	
	protected static final int seconds = 10;
	WebDriver driver;

	public AbstractClass(WebDriver driver)
	{
		this.driver=driver;
	}

	public void scrollDownOnProductsPage()
	{
	  JavascriptExecutor Js = (JavascriptExecutor)driver;
	  Js.executeScript("window.scrollBy(0,1200)");  
	}
	
	public void selectDropdownByIndex(WebElement ele, int index)
	{
		Select select = new Select(ele);
		select.selectByIndex(index);
		
	}
	
	public void selectDropdownByText(WebElement ele, String text)
	{
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}
	
	public void waitForTheElementToAppear(WebElement Locator) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(Locator));
		                                                                      
	}
	
	public WebElement getWebElement(WebElement locator)
	{
		// Wait for the element to be visible (best-effort) and then return it.
		try {
			waitForTheElementToAppear(locator);
		} catch (InterruptedException e) {
			// Restore interrupted status and continue returning the element
			Thread.currentThread().interrupt();
		}
		return locator;
		
	}
	public void highlightElement (WebElement Locator)
	{
		WebElement element = this.getWebElement(Locator);
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		Js.executeScript("arguments[0].style.border='3px solid red';", element);
	}
	
	public void removeHighlightElement(WebElement Locator)
	{
		WebElement element = this.getWebElement(Locator);
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		Js.executeScript("arguments[0].style.border ='';", element);
		
	}
	

}