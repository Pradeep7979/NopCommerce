package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractPackage.AbstractClass;

public class ProductCatalougePage extends AbstractClass

{

	WebDriver driver; 
	public ProductCatalougePage(WebDriver driver)
	{
		super(driver);
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='product-item']")
	List<WebElement> products;
	
	By addToCart = By.cssSelector("button[type='button']:first-of-type");
	
	public List<WebElement> getProductList()
	{
		scrollDownOnProductsPage();
		return products;
	}
	
	public WebElement getProductsByName(String productName)
	{
		WebElement prod =getProductList().stream().filter(product-> 
		product.findElement(By.cssSelector("h2.product-title")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	
	public void addProductToCart(String productName)
	{
		WebElement prod = getProductsByName(productName);
		highlightElement(prod);
		removeHighlightElement(prod);
		prod.findElement(addToCart).click();

	}
	
}
