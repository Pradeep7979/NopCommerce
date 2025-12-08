package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.Checkout;
import Pages.ProductCatalougePage;
import Pages.ProductDetails_Computer;
import Pages.ShoppingCart;
import Utils.BaseTest;

public class Build_Own_Computer_Test extends BaseTest
{

	@Test
	public void Desktop() throws  InterruptedException, IOException
	{		
		String productName = "Build your own computer";
		
		ProductCatalougePage productCat =new ProductCatalougePage(driver);
		ProductDetails_Computer prodDetails = new ProductDetails_Computer(driver);
		ShoppingCart shop = new ShoppingCart(driver);
		Checkout checkout = new Checkout(driver);
	
	  loginPage.loginPageApplication("pradeepgarikimukku@gmail.com", "123456");
	  
		productCat.getProductsByName(productName);
	  productCat.addProductToCart(productName);
	  
	  prodDetails.productDetails_processor(1);
	  prodDetails.productDetails_Ram(1);
	  prodDetails.clickOnHDD();
	  prodDetails.clickOnCartButton();
	  prodDetails.clickOnShoppingCart();
		
	  shop.clickOnTermsOfService();
	  shop.clickOnCheckout();
	  
	  checkout.enterProvince(1);
	  checkout.enterCity("london");
	  checkout.enterAddress("8 watling street");
	  checkout.enterPostalCode("N5Y 3N3");
	  checkout.enterPhoneNumber("3828823338");
	  Thread.sleep(5000);
	  checkout.clickOnSaveAddressButton();
	  checkout.clickOnShippingMethodsContinueButton();
	  checkout.chooseCreditCardPaymentMethod("pradeep", "342210749744381", "12", "123");
				
	
	}
	

}
