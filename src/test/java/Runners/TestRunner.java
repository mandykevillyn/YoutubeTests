package Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "StepsDefinition" }, monochrome = true,
		plugin = { "pretty", "html:target/reports/report.html", "json:target/reports/cucumber.json",
				"junit:target/reports/cucumber.xml" },

		tags = "")
public class TestRunner {
}