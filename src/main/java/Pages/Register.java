package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractPackage.AbstractClass;
import Resources.ReportLogger;

public class Register extends AbstractClass
{

	WebDriver driver;
	public Register(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText = "Register")
	WebElement RegisterButton;
	
	@FindBy(id = "gender-male")
	WebElement MaleGenderRadioButton;
	
	@FindBy(id = "gender-female")
	WebElement FemaleGenderRadioButton;
	
	@FindBy(id = "FirstName")
	WebElement FirstName;
	
	@FindBy(id = "LastName")
	WebElement LastName;
	
	@FindBy(id = "Email")
	WebElement Email;
	
	@FindBy(id = "Password")
	WebElement Password;
	
	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPassword;
	
	@FindBy(id = "register-button")
	WebElement registrationCompleteButton;
	
	@FindBy(xpath = "//div//a[@class='button-1 register-continue-button']")
	WebElement ContinueButton;

	
	public void ClickOnRegsiterButton()
	{
		highlightElement(RegisterButton);
		RegisterButton.click();
		removeHighlightElement(RegisterButton);
	}
	
	public void selectGender(String gender) throws IOException
	{
		if (gender.equals("male"))
		{
			highlightElement(MaleGenderRadioButton);
			MaleGenderRadioButton.click();
			removeHighlightElement(MaleGenderRadioButton);
			ReportLogger.logStepWithScreenshot("Entered Gender:"+gender, driver);
		}
		else if (gender.equals("female"))
		{
			highlightElement(FemaleGenderRadioButton);
			FemaleGenderRadioButton.click();
			removeHighlightElement(FemaleGenderRadioButton);
			ReportLogger.logStepWithScreenshot("Entered Gender:"+gender, driver);
			
		}
	}
		
		public void enterResgisterFirstName(String firstName1) throws IOException
		{
			highlightElement(FirstName);
			FirstName.sendKeys(firstName1);
			removeHighlightElement(FirstName);
			ReportLogger.logStepWithScreenshot("Entered First Name:"+firstName1, driver);
		}
		public void enterRegisterLastName(String lastName1) throws IOException
		{
			highlightElement(LastName);
			LastName.sendKeys(lastName1);
			removeHighlightElement(LastName);
			ReportLogger.logStepWithScreenshot("Entered Last Name:"+lastName1, driver);
		}
		
		public void enterRegisterEmail(String email1) throws IOException
		{
			highlightElement(Email);
			Email.sendKeys(email1);
			removeHighlightElement(Email);
			ReportLogger.logStepWithScreenshot("Entered Email:"+email1, driver);
		}
		
		public void enterRegisterPassword(String password1) throws IOException
		{
			highlightElement(Password);
			Password.sendKeys(password1);
			removeHighlightElement(Password);
			ReportLogger.logStepWithScreenshot("Entered Password:"+ password1, driver);
		}
		
		public void enterRegisterConfirmPassword(String confirmPassword1) throws IOException
		{
			highlightElement(ConfirmPassword);
			ConfirmPassword.sendKeys(confirmPassword1);
			removeHighlightElement(ConfirmPassword);
			ReportLogger.logStepWithScreenshot("Entered Confirm Password:"+confirmPassword1, driver);
		}
		
		public void clickOnRegistrationCompleteButton() throws InterruptedException, IOException
		{
			
				highlightElement(registrationCompleteButton);
				registrationCompleteButton.click();
				ReportLogger.logStepWithScreenshot("Clicked on Registration Complete Button", driver);
			
			
		}
		
		public void clickOnContinueButton() throws InterruptedException, IOException
		{
				waitForTheElementToAppear(ContinueButton);
				highlightElement(ContinueButton);
				ContinueButton.click();
				ReportLogger.logStepWithScreenshot("Clicked on Continue Button", driver);
				//removeHighlightElement(ContinueButton);
		
		}
		
}
