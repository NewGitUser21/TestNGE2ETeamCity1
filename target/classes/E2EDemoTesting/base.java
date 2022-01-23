package E2EDemoTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	
	//After adding url to data properties file
	//global declaration of prop variable to access it across the classes
	
	// public static Properties prop;
 
	//It is important to declare Properties instance globally
	
	 static Properties prop = new Properties();
	
	@SuppressWarnings({ "deprecation" })
	public static WebDriver initializeDriver() throws IOException  //void changed to WebDriver
	{
		//HomePage HP = new HomePage(driver);
		
		//This*
		//FileNotFound Exception will throw when we change the file directory
		//Properties prop = new Properties();
		//FileInputStream fis = new FileInputStream("\\C:\\Users\\DELL\\eclipse-workspace\\TestNG Practice\\E2EProject\\src\\main\\java\\E2EDemoTesting\\data.properties");
		
		
		//FileNotFound Exception will throw when we change the file directory so the below process will over come that
		//Load data from properties file from File location
		
		//This*
		String propFilePath = System.getProperty("user.dir")+"/src/main/java/E2EDemoTesting/data.properties";
		FileInputStream fis = new FileInputStream(propFilePath);
		
		//This*
		//String projectPath = System.getProperty("user.dir");
		//FileInputStream fis = new FileInputStream(projectPath+"/src/main/java/E2EDemoTesting/data.properties");
		
		prop.load(fis);
		
		//Read Data
		
		String browserName = prop.getProperty("browser");
		@SuppressWarnings("unused")
		String urlName = prop.getProperty("url");
		
		
		//After adding url to data properties file
		
		//String urlName = prop.getProperty("url");
		
		
		
		/*
		 * FAILED: basePageNavigation java.lang.NullPointerException: Cannot invoke
		 * "org.openqa.selenium.WebDriver.manage()" because "this.driver" is null
		 */
		
		//if(browserName=="Chrome")
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			String projectPath = System.getProperty("user.dir");
			//System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\chromedriver.exe"); 
			//C:\Users\DELL\eclipse-workspace\TestNG Practice\E2EProject\Driver\chromedriver.exe
			System.setProperty("webdriver.chrome.driver", projectPath+"/Driver/chromedriver.exe");		
			driver = new ChromeDriver();
		}
		//else if(browserName=="firefox")
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			String projectPath = System.getProperty("user.dir"); 
			//C:\Users\DELL\eclipse-workspace\TestNG Practice\E2EProject\Driver\geckodriver.exe
			System.setProperty("webdriver.gecko.driver", projectPath+"/Driver/geckodriver.exe");		
			driver = new FirefoxDriver();
		}
		//else if(browserName=="IE") 
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			String projectPath = System.getProperty("user.dir"); 
			//C:\Users\DELL\eclipse-workspace\TestNG Practice\E2EProject\Driver\IEDriverServer.exe
			//C:\Users\DELL\eclipse-workspace\TestNG Practice\E2EProject\Driver\msedgedriver.exe
			System.setProperty("webdriver.edge.driver", projectPath+"/Driver/msedgedriver.exe");		
			driver = new EdgeDriver();	
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;	
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destintionFile = System.getProperty("user.dir")+"/CustomReports/"+testCaseName+".png";
		//Apache Commons IO dependency
		FileUtils.copyFile(source, new File(destintionFile));
		
		//For ThreadLocal class and parallel execution which will capture screenshot and places in path given and return that path
		return destintionFile;
		
	}
	
	
	
	
	
	
	
	
}
