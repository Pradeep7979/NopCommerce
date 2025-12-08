package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractPackage.AbstractClass;

public class ShoppingCart extends AbstractClass

{

	WebDriver driver; 
	public ShoppingCart(WebDriver driver)
	{
		super(driver);
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="checkout")
	WebElement checkout;
	
	@FindBy(name = "termsofservice")
	WebElement termsofservice ;
	
		
		
	public void clickOnTermsOfService()
	{
		highlightElement(termsofservice);
		removeHighlightElement(termsofservice);
		termsofservice.click();
			
	}
	public void clickOnCheckout()
	{
		highlightElement(checkout);
		removeHighlightElement(checkout);
		checkout.click();
	}
	
	
}
