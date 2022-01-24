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
package E2EDemoTesting;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		Reporter.log("Driver is initialized");
		
        String urlName = prop.getProperty("url");	
		driver.get(urlName);
		log.info("Navigated to Home Page");
		Reporter.log("Navigated to Home Page");
		
	}
	
	
	//@Test(dataProvider="getData")
	@Test
	public static void basePageNavigation() throws IOException, InterruptedException
	{ 
		//HomePage HP = new HomePage();
		//driver = initializeDriver();
		
		//Pass URL through driver object
		
		//Before adding url to global data properties file
		//driver.get("https://qaclickacademy.com/");
		
		
		//After adding url to global data properties file
		//prop.getProperty("url")
		
		//String urlName = prop.getProperty("url");
		
		//driver.get(urlName);
		
		LandingPage l = new LandingPage(driver);
		
		//l.getNavigationBar().isDisplayed();
		
		
		//Argument expect always to be True
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		
		log.info("Navigate Bar is displayed");
		Reporter.log("Navigate Bar is displayed");
		
			
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		//driver.quit();
		
		log.info("Driver closed");
		Reporter.log("Driver closed");
	}

}
