/**
 * 
 */
package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author DELL
 *
 */
public class stepDefinition {
	
	public WebDriver driver = null;
	
	@SuppressWarnings({ "deprecation" })
	@Given("Initialize the browser as chrome")
	public void initialize_the_browser_as_chrome() {
	    // Write code here that turns the phrase above into concrete actions
		
		String projectPath = System.getProperty("user.dir");
		//System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\chromedriver.exe"); 
		//C:\Users\DELL\eclipse-workspace\CucumberDemo\Automation\Driver\chromedriver.exe
		System.setProperty("webdriver.chrome.driver", projectPath+"/Driver/chromedriver.exe");
		
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    
	}
	@Given("Navigate to login site")
	public void navigate_to_login_site() {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.get("https://qaclickacademy.com/");
	    
	}
	@Given("Click on Login link in home page to navigate to secure sign in page")
	public void click_on_login_link_in_home_page_to_navigate_to_secure_sign_in_page() {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.cssSelector("a[href*='sign_in']")).click();
	    
	}
	@When("User enters username and password and logs in")
	public void user_enters_username_and_password_and_logs_in() {
	    // Write code here that turns the phrase above into concrete actions
	    
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("abc@qw.com");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("123456");
		
	}
	@Then("Verify the user is successfully logged in")
	public void verify_the_user_is_successfully_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("User accessed Login Page");
	    
	}
	
	
	}


