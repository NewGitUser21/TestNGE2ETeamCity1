/**
 * 
 */
package cucumberOptions;

//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

/**
 * @author DELL
 * 
 * 
 * Cucumber & TestNG integration
 * AbstractTestNGCucumberTests – Runs each cucumber scenario found in the features as separated test.
 * 
 * WARNING: Ignoring options provided by io.cucumber.junit.CucumberOptions on cucumberOptions.TestRunner. It is recommend to use separate runner classes for JUnit and TestNG.
 * Jan 25, 2022 10:58:07 PM io.cucumber.core.runtime.FeaturePathFeatureSupplier get
 * WARNING: No features found at classpath:/cucumberOptions
 * 
 * So write separate classes for Junit and TestNG unit testing
 * 
 */

@CucumberOptions(
		tags = "",
		features = "src/test/java/features/Login.feature",
		glue={"stepDefinitions"}
		)

public class TestRunner2 extends AbstractTestNGCucumberTests {
	
	
    //Run As TestNG
	//run through command prompt
	//Get the project path
	//cd project path
	//mvn compile
	//mvn clean install
	//refresh the project
	
}
