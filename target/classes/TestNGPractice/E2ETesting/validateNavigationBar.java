/**
 * 
 * Adding logs using Log4j
 * 
 * log4j xml file
 * 
 * Generating reports
 * 
 * Screenshots on Failure
 * 
 * Jenkins Integration
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
 * Adding Tests to Suite in Framework guidelines
 * 
 * Shift+Ctrl+'O' - To remove unused imports
 *
 */
public class validateNavigationBar extends base {

	
	//Mandatory for Log4j, declaration of Log Object declaration
		public static Logger log = LogManager.getLogger(base.class.getName());
		
		public static WebDriver driver;
	
		/*
		 * @BeforeTest public void initialize() throws IOException, WebDriverException,
		 * InterruptedException { driver = initializeDriver();
		 * log.info("Driver is initialized"); Reporter.log("Driver is initialized");
		 * 
		 * String urlName = prop.getProperty("url"); driver.get(urlName);
		 * log.info("Navigated to Home Page"); Reporter.log("Navigated to Home Page");
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
		
		//l.getNavigationBar().isDisplayed();
		
		
		//Argument expect always to be True
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		
		log.info("Navigate Bar is displayed");
		Reporter.log("Navigate Bar is displayed");
			
	}
	
	/*
	 * @AfterTest public void tearDown() { driver.close(); //driver.quit();
	 * 
	 * log.info("Driver closed"); Reporter.log("Driver closed"); }
	 */
}
