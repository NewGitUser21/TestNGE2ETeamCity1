/**
 * 
 */
package TestNGPractice.E2ETesting;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @author DELL
 * 
 * Asserting test cases with validations
 * 
 * Shift+Ctrl+'O' - To remove unused imports
 *
 */
public class validateTitle extends base {
	
	//Mandatory for Log4j, declaration of Log Object declaration
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	public static WebDriver driver;
	
	/*
	 * @BeforeTest public void initialize() throws IOException, WebDriverException,
	 * InterruptedException { driver = initializeDriver();
	 * log.info("Driver is initialized"); Reporter.log("Driver is initialized");
	 * 
	 * String urlName = prop.getProperty("url"); driver.get(urlName);
	 * 
	 * log.info("Navigated to Home Page"); Reporter.log("Navigated to Home Page");
	 * 
	 * 
	 * }
	 */
	
	
	//@Test(dataProvider="getData")
	@Test
	public static void basePageNavigation() throws IOException, InterruptedException, WebDriverException, SocketTimeoutException
	{ 
		driver = initializeDriver();
		log.info("Driver is initialized");
		Reporter.log("Driver is initialized");
		
        String urlName = prop.getProperty("url");	
		driver.get(urlName);
		
		log.info("Navigated to Home Page");
		Reporter.log("Navigated to Home Page");
		
		LandingPage l = new LandingPage(driver);
		
		//Compare the text with actual title text, if not then the script will fail
		
		//Assert.assertEquals(l.getTitle().getText(), "Featured Courses123");
		
		/*
		 * Error Log FAILED: basePageNavigation java.lang.AssertionError: expected
		 * [Featured Courses123] but found [FEATURED COURSES]
		 */
		
		//Assert.assertEquals(l.getTitle().getText(), "Featured Courses");
		
		/*
		 * Error Log FAILED: basePageNavigation java.lang.AssertionError: expected
		 * [Featured Courses] but found [FEATURED COURSES]
		 */
		
		//System.out.println(l.getTitle().getText());
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		
		//PASSED: basePageNavigation
		
		log.info("Successfully validated text message");
		Reporter.log("Successfully validated text message");

		
	}
	
	/*
	 * @AfterTest public void tearDown() { driver.close(); //driver.quit();
	 * 
	 * log.info("Driver closed"); Reporter.log("Driver closed"); }
	 */

}
