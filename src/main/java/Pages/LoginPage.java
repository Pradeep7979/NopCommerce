package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractPackage.AbstractClass;

public class LoginPage extends AbstractClass
{

	WebDriver driver;
	
	//initialization 
	public LoginPage(WebDriver driver)
	{
		super(driver);
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
	//WebElement email = driver.findElement(By.id("Email"));
	
	@FindBy(linkText ="Log in")
	WebElement loginLink;
	
	@FindBy(id = "Email")
	WebElement userEmail;
	
	@FindBy(id="Password")
	WebElement userPassword;
	
	@FindBy(css ="button[class='button-1 login-button']")
	WebElement loginButton;
	
	@FindBy(xpath ="//div[@class='message-error validation-summary-errors']")
	WebElement errorMessage;
	public void loginPageApplication(String email, String password)
	{
		highlightElement(loginLink);
		loginLink.click();
		removeHighlightElement(loginLink);
		
		highlightElement(userEmail);
		userEmail.sendKeys(email);
		removeHighlightElement(userEmail);
		
		highlightElement(userPassword);
		userPassword.sendKeys(password);
		removeHighlightElement(userPassword);
		
		highlightElement(loginButton);
		removeHighlightElement(loginButton);
		loginButton.click();
		
	}
	
	public void Goto()
	{
		driver.get("http://localhost:5000/");
	}

	public String getErrorMessage()
	{
		
	 		highlightElement(errorMessage);
		String errorText = errorMessage.getText();
		removeHighlightElement(errorMessage);
		return errorText;
	}

	
	
	
}
