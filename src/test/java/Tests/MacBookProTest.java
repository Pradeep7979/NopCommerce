package Tests;

import org.testng.annotations.Test;

import Pages.Checkout;
import Pages.ProductCatalougePage;
import Pages.ProductDetails_MacBookPro;
import Pages.ShoppingCart;
import Utils.BaseTest;

public class MacBookProTest extends BaseTest
{

	@Test
	public void TC_01_MacBookPro () throws InterruptedException
	{
		String productName = "Apple MacBook Pro";
		ProductCatalougePage prodCat = new ProductCatalougePage(driver);
		ProductDetails_MacBookPro prodDetails = new ProductDetails_MacBookPro(driver);
		ShoppingCart shop = new ShoppingCart(driver);
		Checkout checkout = new Checkout(driver);
		
		
		loginPage.loginPageApplication("pradeepgarikimukku@gmail.com", "123456");
		prodCat.getProductsByName(productName);
		prodCat.addProductToCart(productName);
		prodDetails.clickOnAddToCartButton();
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
