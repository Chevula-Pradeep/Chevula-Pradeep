package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", // Path to the feature files
		glue = { "stepDefinitions" }, // Package where step definitions are located
		tags = "@smokeTests", // Tags to include for execution (optional)
		// plugin = {"pretty", "html:target/results/cucumber-reports",
		// "html:target/results/cucumber.xml","html:target/results/cucumber-report.json"}
		plugin = { "pretty", "html:target/results/HtmlReports" } // Plugins for reporting (optional)

)
public class TestRunnerFiles {

}
