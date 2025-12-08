package Pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractPackage.AbstractClass;

public class Checkout extends AbstractClass

{

	WebDriver driver; 
	public Checkout(WebDriver driver)
	{
		super(driver);
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="BillingNewAddress_StateProvinceId")
	WebElement province;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement city;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement address;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postalCode;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneNumber;
	
	@FindBy(id="shipping-method-buttons-container")
	WebElement ShippingMethodsCountinueButton;
	
	@FindBy(id="paymentmethod_1")
	WebElement creditCardPaymentMethod;
	
	@FindBy(id="payment-method-buttons-container")
	WebElement creditCardContinueButton;
	
	@FindBy(id="CardholderName")
	WebElement creditCardHolderName;
	
	@FindBy(id ="CardNumber")
	WebElement cardNumber;
	
	@FindBy(id ="ExpireMonth")
	WebElement ExpireMonth;
	
	@FindBy(id ="CardCode")
	WebElement CardCode;
	
	@FindBy(id ="payment-info-buttons-container")
	WebElement paymentsContinueButton;
	
	@FindBy(id ="confirm-order-buttons-container")
	WebElement ConfirmOrderButton;
	
	@FindBy(name = "save")
	WebElement SaveButton ;
	
	
	
	public void enterProvince(int index) throws InterruptedException
	{
		 List<WebElement> editButtons = driver.findElements(By.id("edit-billing-address-button"));

	    if (!editButtons.isEmpty() && editButtons.get(0).isDisplayed()
	            && editButtons.get(0).getText().equalsIgnoreCase("Edit")) {

	        WebElement editButton = editButtons.get(0);
	        editButton.click();
	        Thread.sleep(4000);

	        selectDropdownByIndex(province, index);
	    }
		else
		{
		 selectDropdownByIndex(province, index);
		}
	}
	
	public void enterCity(String City)
	{
		highlightElement(city);
		city.clear();
		city.sendKeys(City);
		removeHighlightElement(city);
	}
	
	public void enterAddress(String address1)
	{
		highlightElement(address);
		address.clear();
		address.sendKeys(address1);
		removeHighlightElement(address);

	}
	
	public void enterPostalCode(String postalCode1)
	{
		highlightElement(postalCode);
		postalCode.clear();
		postalCode.sendKeys(postalCode1);
		removeHighlightElement(postalCode);

	}
	
	public void enterPhoneNumber(String phoneNumber1)
	{
		highlightElement(phoneNumber);
		phoneNumber.clear();
		phoneNumber.sendKeys(phoneNumber1);
		removeHighlightElement(phoneNumber);

	}
	
	public void clickOnShippingMethodsContinueButton()
	{
		highlightElement(ShippingMethodsCountinueButton);
		removeHighlightElement(ShippingMethodsCountinueButton);
		ShippingMethodsCountinueButton.click();
	}
	
	public void chooseCreditCardPaymentMethod(String cardHolderName, String cardNumber1, String ExpireMonth1,String cardCode1)
	{
		highlightElement(creditCardPaymentMethod);
		removeHighlightElement(creditCardPaymentMethod);
		creditCardPaymentMethod.click();
		
		highlightElement(creditCardContinueButton);
		removeHighlightElement(creditCardContinueButton);
		creditCardContinueButton.click();
		
		highlightElement(creditCardHolderName);
		creditCardHolderName.sendKeys(cardHolderName);
		removeHighlightElement(creditCardHolderName);

		highlightElement(cardNumber);
		cardNumber.sendKeys(cardNumber1);
		removeHighlightElement(cardNumber);
		
		highlightElement(ExpireMonth);
		ExpireMonth.sendKeys(ExpireMonth1);
		removeHighlightElement(ExpireMonth);
		
		highlightElement(CardCode);
		CardCode.sendKeys(cardCode1);
		removeHighlightElement(CardCode);
		
		highlightElement(paymentsContinueButton);
		paymentsContinueButton.click();
		
	}
	
	public void clickOnSaveAddressButton()
	{
		SaveButton.click();
	}
	
	
	
	
		
	
	
	
}
