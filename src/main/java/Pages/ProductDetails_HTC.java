package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractPackage.AbstractClass;

public class ProductDetails_HTC extends AbstractClass
{
	WebDriver driver;
	public ProductDetails_HTC(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText = "Shopping cart")
	WebElement ShoppingCart;
	
	public void clickOnShoppingCart()
	{
		highlightElement(ShoppingCart);
		removeHighlightElement(ShoppingCart);
		ShoppingCart.click();
	}

}
