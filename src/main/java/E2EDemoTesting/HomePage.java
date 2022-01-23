package E2EDemoTesting;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.TestNGException;

/**
 * 
 * There are two ways access methods of other class; 
 * 1. Inheritance (extend the base class), 
 * 2. Create Instance (object) of other class and invoke methods
 * 
 * Data provider annotation
 * 
 * Java is case sensitive
 * 
 * 
 */

@SuppressWarnings({ "unused" })
public class HomePage extends base{
	
	//Mandatory for Log4j, declaration of Log Object declaration
		public static Logger log = LogManager.getLogger(base.class.getName());
		
		public static WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		//log.info("Driver is initialized");
		Reporter.log("Driver is initialized");
		
        String urlName = prop.getProperty("url");	
		driver.get(urlName);
		//log.info("Navigated to Home Page");
		Reporter.log("Navigated to Home Page");
		
	}
	
@Test
public static void basePageNavigation() throws IOException, InterruptedException
{ 
	//HomePage HP = new HomePage();
	driver = initializeDriver();
	
	//Pass URL through driver object
	
			//Before adding url to global data properties file
			//driver.get("https://qaclickacademy.com/");
			
			
			//After adding url to global data properties file
	String urlName = prop.getProperty("url");
	
	driver.get(urlName);
	
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
	
	//*Handling Frame
	
	//<iframe id="sumome-jquery-iframe" title="Sumo Hidden Content" style="display: none;" xpath="1">
	
	//System.out.println(driver.switchTo().frame("sumome-jquery-iframe"));
	//driver.findElement(By.xpath("//div[@class='sumome-react-svg-image-container']")).click();
	
	//*Handling Alerts
	
	  //Alert alert = driver.switchTo().alert();
	  //System.out.println(alert.getText());
	  //alert.dismiss();
	 
	
	//*Handling separate pop-up windows on click on any link or button on same home page
	
	/*
	 * String HomePage = driver.getWindowHandle(); System.out.println(HomePage);
	 * 
	 * //put WebElement locator here //Generally when you click on any link and you
	 * get pop-up window in return. //Here in this case I get simple pop-up window
	 * without clicking on any button or link
	 * 
	 * String PopUpPage = driver.getWindowHandle(); System.out.println(PopUpPage);
	 * 
	 * Set<String> windows = driver.getWindowHandles();
	 * System.out.println(windows.size()); //OutPut: 1 (window) - so simply added
	 * xpath command to click on No Thanks button. //If it had 2 windows then
	 * 
	 * Iterator iterator = windows.iterator(); String currentWindowId;
	 * 
	 * while(iterator.hasNext()) { currentWindowId = iterator.next().toString();
	 * System.out.println(currentWindowId);
	 * 
	 * if(!currentWindowId.equals(HomePage)) {
	 * driver.switchTo().window(currentWindowId);
	 * driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
	 * //Script passed - however pop-up windows appears after few seconds } }
	 */
	
	LandingPage l = new LandingPage(driver);
	l.getLogin().click();
	
	LoginPage lp = new LoginPage(driver);
	lp.getEmail().sendKeys("abc@qw.com");
	lp.getPassword().sendKeys("123456");
	//Thread.sleep(2000);
		
	lp.getLogin().click();	
	
	//log.info("User Login with Invalid credentials");
	Reporter.log("User Login with Invalid credentials");
}

//@Test(dataProvider="getData")
public static void basePageNavigation(String Username,String Password,String text) throws IOException, InterruptedException
{ 
	//HomePage HP = new HomePage();
	driver = initializeDriver();
	
	//driver.get("https://qaclickacademy.com/");
	
	String urlName = prop.getProperty("url");
	
	driver.get(urlName);
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
	
	LandingPage l = new LandingPage(driver);
	l.getLogin().click();
	
	LoginPage lp = new LoginPage(driver);
	
	lp.getEmail().sendKeys(Username);
	lp.getPassword().sendKeys(Password);
	System.out.println(text);
	
	lp.getLogin().click();	
}


@AfterTest
public void tearDown()
{
	driver.close();
	//sdriver.quit();
	
	Reporter.log("Driver closed");
}

//Parameterization
@DataProvider
public Object[][] getData()
{
	//row stands for how many different data types test should run
	//column stands for how many values for each test
	
	//Object[][] data = new Object[1][2]; //ThrowsArray OutofBound Exception
	
	Object[][] data = new Object[2][3];
	
	//0th row
	data[0][0] = "nonrestricteduser@qw.com";
	data[0][1] = "123456";
	data[0][2] = "Restricted User";
	
	//1st row
	data[1][0] = "restricteduser@qw.com";
	data[1][1] = "456788";
	data[1][2] = "Non Restricted User";
	
	return data;	
	
}


}
