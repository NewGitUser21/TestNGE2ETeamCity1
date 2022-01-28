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
 * TestRunner using junit unit testing
 * 
 * TestRunner using maven run
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue={"stepDefinitions"},
		monochrome=true,
		plugin={"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"}
		)

public class TestRunner {

	//run through command prompt
	//Get the project path
	//cd project path
	//mvn compile
	//mvn clean install
	//refresh the project
	
}
