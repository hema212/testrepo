package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginObjects {
	public WebDriver driver;

	By email = By.id("email");
	By password = By.id("password");
    By signin = By.xpath("//span[contains(text(), 'Sign in')]");
    By headervalue = By.xpath("//h5");
    By invalidcred = By.xpath("//div[@class='MuiFormControl-root jss26']/label");
    
	public loginObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsernameObject() {
		return this.driver.findElement(email);
	}
	
	public WebElement getPasswordObject() {
		return this.driver.findElement(password);
	}
	
	public WebElement signinObject() {
		return this.driver.findElement(signin);
	}
	
	public WebElement getHeader() {
		return this.driver.findElement(headervalue);
	}
	
	public WebElement getInvalidCredText() {
		return this.driver.findElement(invalidcred);
	}
}
