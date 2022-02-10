/**
 * 
 */
package TestNGPractice.E2ETesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author DELL
 *
 */
public class LoginPage {
	
	public WebDriver driver;

	////input[@id='user_email']
	////input[@id='user_password']
	////input[@type='submit']
	
	//Page object mechanism
	By email = By.xpath("//input[@id='user_email']");
	By password = By.xpath("//input[@id='user_password']");
	By login = By.xpath("//input[@type='submit']");
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getEmail() 
	{
		
		return driver.findElement(email);	
	} 
	
	public WebElement getPassword() 
	{
		
		return driver.findElement(password);	
	}
	
	public WebElement getLogin() 
	{
		
		return driver.findElement(login);	
	}
	
}
