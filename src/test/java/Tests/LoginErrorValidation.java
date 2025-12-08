package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class LoginErrorValidation extends BaseTest
{

	@Test
	public void loginErrorValidationTest()
	{
		loginPage.loginPageApplication("pradeepgarikimukku@gmail.com", "12345");
	Assert.assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n"+ "The credentials provided are incorrect");
	}
}
