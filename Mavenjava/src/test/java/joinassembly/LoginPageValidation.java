package joinassembly;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.loginObjects;
import resources.Base;

public class LoginPageValidation extends Base {
	private static Logger log = LogManager.getLogger(LoginPageValidation.class.getName());
	@BeforeTest
	public void init() throws FileNotFoundException, IOException {
		driver = initializeDriver();
	}

	@Test(dataProvider="getData")
	public void validateLogin(String email, String password) throws FileNotFoundException, IOException {
		driver = initializeDriver();
		driver.get(baseurl);
		log.info("Navigated to the provided URL");
		//Create an object for loginObjects class of pageObjects
		loginObjects loginobject = new loginObjects(driver);
		System.out.println("first stage");
		String actualheader = loginobject.getHeader().getText();
		String expectedheader = "Welcome back!";
		//Check for Assertion
		Assert.assertEquals(actualheader, expectedheader);
		loginobject.getUsernameObject().sendKeys(email);
		loginobject.getPasswordObject().sendKeys(password);
		loginobject.signinObject().click();
		String errormessage = loginobject.getInvalidCredText().getText();
		// Validate for valid user
		if(errormessage != null) {
			log.error("Invalid credentials :(");
		}
		else {
			log.info("Successfully logged into Assembly homepage!");
		}
	}
	
	/*
	 * @AfterTest public void closedriver() { driver.close(); }
	 */
	
	@DataProvider
	public Object[][] getData() {
		Object[][] logindata = new Object[2][2];
		logindata[0][0] = "abc@carrothr.com";
		logindata[0][1] = "password123";
		
		logindata[1][0] = "abc@gmail.com";
		logindata[1][1] = "working";
		
		return logindata;
	}
}
