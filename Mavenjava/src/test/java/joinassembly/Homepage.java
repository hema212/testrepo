package joinassembly;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.loginObjects;
import resources.Base;

public class Homepage extends Base {

	@Test(dataProvider="getData")
	public void validateLogin(String email, String password) throws FileNotFoundException, IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(baseurl);
		
		  loginObjects loginobject = new loginObjects(driver); 
		  System.out.println("first step");
		 loginobject.getUsernameObject().sendKeys(email);
		 loginobject.getPasswordObject().sendKeys(password); Thread.sleep(2000L);
		 loginobject.signinObject().click();
		 
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] logindata = new Object[2][2];
		logindata[0][0] = "abc@carrothr.com";
		logindata[0][1] = "password123";
		
		logindata[1][0] = "abc@gmail.com";
		logindata[1][1] = "password123";
		
		return logindata;
	}
}
