package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractPackage.AbstractClass;

public class ProductDetails_GiftCard extends AbstractClass
{
	
	public WebDriver driver;
	public ProductDetails_GiftCard(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (id = "giftcard_43_RecipientName")
	WebElement RecipientName;
	
	@FindBy(id = "giftcard_43_RecipientEmail")
	WebElement RecipientEmail;
	
	@FindBy (id = "giftcard_43_SenderName")
	WebElement SenderName;
	
	@FindBy (id= "giftcard_43_SenderEmail")
	WebElement SenderEmail;
	
	@FindBy (id = "giftcard_43_Message")
	WebElement Message;
	
	@FindBy (id ="add-to-cart-button-43")
	WebElement addToCartButton;
	
	@FindBy(linkText = "Shopping cart")
	WebElement ShoppingCart;
	
	public void clickOnShoppingCart()
	{
		ShoppingCart.click();
	}
	public void enterReicpentName(String recipientName)
	{
		highlightElement(RecipientName);
		removeHighlightElement(RecipientName);
		RecipientName.clear();
		RecipientName.sendKeys(recipientName);
	}
	
	public void enterRecipientEmail(String recipientEmail)
	{
		highlightElement(RecipientEmail);
		removeHighlightElement(RecipientEmail);
		RecipientEmail.clear();
		RecipientEmail.sendKeys(recipientEmail);
		
	}
	
	public void enterSenderName(String senderName)
	{
		highlightElement(SenderName);
		removeHighlightElement(SenderName);
		SenderName.clear();
		SenderName.sendKeys(senderName);
	}
	
	public void enterSenderEmail(String senderEmail)
	{
		highlightElement(SenderEmail);
		removeHighlightElement(SenderEmail);
		SenderEmail.clear();
		SenderEmail.sendKeys(senderEmail);
		
	}
	
	public void enterMessage(String message)
	{
		highlightElement(Message);
		removeHighlightElement(Message);
		Message.clear();
		Message.sendKeys(message);
		
	}
	public void clickOnAddToCartButton()
	{
		highlightElement(addToCartButton);
		removeHighlightElement(addToCartButton);
		addToCartButton.click();
	}
	
	

}
