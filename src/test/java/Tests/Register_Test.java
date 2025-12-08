package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Register;
import Resources.DataProviderJson;
import Utils.BaseTest;

public class Register_Test extends BaseTest
{
 
	@Test(dataProvider = "registerData")
	public void  registerTest(HashMap<String, String> data) throws InterruptedException, IOException
	{
		Register register = new Register(driver);
		register.ClickOnRegsiterButton();
		register.selectGender(data.get("Gender"));
		register.enterResgisterFirstName(data.get("FirstName"));
		register.enterRegisterLastName(data.get("LastName"));
		register.enterRegisterEmail(data.get("Email")+ generateRandomNumber()+"@gmail.com");
		register.enterRegisterPassword(data.get("Password"))	;
		register.enterRegisterConfirmPassword(data.get("ConfirmPassword"));
		register.clickOnRegistrationCompleteButton();
		Thread.sleep(2000);
		register.clickOnContinueButton();
		}
	
	
	private String generateRandomNumber()
	{
		int randomNumber = (int)(Math.random() * 10000);
		return String.valueOf(randomNumber);
	}


	@DataProvider(name="registerData")
	public Object[][] getData() throws IOException
	{
		DataProviderJson dataProvider = new DataProviderJson();
		List<HashMap<String,String>> data =dataProvider.getJsonDataToHashMap(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\RegisterDataProvider.json");
		return new Object[][] {{data.get(0)}} ;//, {data.get(1)}};
		
	}
}