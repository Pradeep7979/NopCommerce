package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractPackage.AbstractClass;

public class ProductDetails_Computer extends AbstractClass

{

	WebDriver driver; 
	public ProductDetails_Computer(WebDriver driver)
	{
		super(driver);
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="product_attribute_1")
	WebElement processorDropdown;
	
	@FindBy(id = "product_attribute_2")
	WebElement ramDropdown;
	
	@FindBy(css = "input#product_attribute_3_7") 	
	WebElement HDD;

	@FindBy(id = "add-to-cart-button-1")
	WebElement AddToCartButton;
	
	@FindBy(css = "p.content")
	WebElement SuccessText;
	
	@FindBy(linkText = "Shopping cart")
	WebElement ShoppingCart;
	
	
	public void productDetails_processor(int index)
	{
		highlightElement(processorDropdown);
		selectDropdownByIndex(processorDropdown,index);
		removeHighlightElement(processorDropdown);
	}
	
	public void productDetails_Ram(int index)
	{
		highlightElement(ramDropdown);
		selectDropdownByIndex(ramDropdown,index);
		removeHighlightElement(ramDropdown);
	}
		
	public void clickOnHDD() throws InterruptedException
	{
		
		waitForTheElementToAppear(HDD);
		highlightElement(HDD);
		removeHighlightElement(HDD);
		HDD.click();
	}		
		
	public void clickOnCartButton() throws InterruptedException
	{
		
		waitForTheElementToAppear(AddToCartButton);
		highlightElement(AddToCartButton);
		removeHighlightElement(AddToCartButton);
		AddToCartButton.click();	
		System.out.println(SuccessText.getText());

	}
	public void clickOnShoppingCart()
	{
		highlightElement(ShoppingCart);
		removeHighlightElement(ShoppingCart);
		ShoppingCart.click();
	}
	
	
}
