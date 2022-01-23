/**
 * 
 * Implement Page Object Mechanism to drive tests
 * Object should be design on top, and methods after that, this is the best practice of Page Object creation
 * 
 */
package E2EDemoTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author DELL
 *
 */
public class LandingPage {

	public WebDriver driver;
	
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	//By signIn = By.xpath("//span[text()='Login']");
	
	By signIn = By.cssSelector("a[href*='sign_in']");
	
	//To verify title in Landing page 'FEATURED COURSES' using assertion
	
	By title = By.cssSelector(".text-center>h2");
	
	//By title = By.xpath("//h2[text()='Featured Courses']"); 
	
	
	//locator for navigation bar
	// <ul class="nav navbar-nav navbar-right" xpath="1">
	//    <li class="active" ... >
	//       <a href"www.jbdvb.com"/>
	
	//cssSelector = .nav.navbar-nav.navbar-right>li>a
	
	By NavBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	
	public WebElement getLogin() //a method can not return without return type
	{
		
		return driver.findElement(signIn);
		
	}
	
	public WebElement getNavigationBar() //a method can not return without return type
	{
		
		return driver.findElement(NavBar);
		
	}
	
	public WebElement getTitle() //a method can not return without return type
	{
		
		return driver.findElement(title);
		
	}
	
	
}
