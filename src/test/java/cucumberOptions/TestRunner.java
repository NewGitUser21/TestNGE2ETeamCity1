/**
 * 
 */
package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * @author DELL
 * 
 * 
 * Cucumber & TestNG integration
 * AbstractTestNGCucumberTests – Runs each cucumber scenario found in the features as separated test.
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "",
		features = "src/test/java/features/Login.feature",
		glue={"stepDefinitions"},
		monochrome=true,
		plugin={"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"}
		)

public class TestRunner {

	//Run As Junit test
	//run through command prompt
	//Get the project path
	//cd project path
	//mvn compile
	//mvn clean install
	//refresh the project
	
	//Because of cucumber.properties file
	//View your Cucumber Report at:                                            
	// https://reports.cucumber.io/reports/ee14211e-30b2-45b3-8363-3e279fc13919
	
	//mvn clean install
	//This will all both test suite simultaneously (TestRunner and TestRunner2 classes)
	
}
