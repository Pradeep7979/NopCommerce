package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractPackage.AbstractClass;

public class ProductDetails_MacBookPro extends AbstractClass
{

		WebDriver driver;
	public ProductDetails_MacBookPro(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="add-to-cart-button-4")
	 WebElement addToCartButton;
	
	@FindBy(linkText = "Shopping cart")
	WebElement ShoppingCart;
	
	public void clickOnAddToCartButton()
	{
		highlightElement(addToCartButton);
		removeHighlightElement(addToCartButton);
		addToCartButton.click();
	}
	
	public void clickOnShoppingCart()
	{
		highlightElement(ShoppingCart);
		removeHighlightElement(ShoppingCart);
		ShoppingCart.click();
	}

}
