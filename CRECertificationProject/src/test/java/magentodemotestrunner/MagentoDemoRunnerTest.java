package magentodemotestrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    
    /*tags = "@tag2", // Tag to select the scenarios to run*/
    features = "src/test/resources", // Path to the feature files
    glue = "magentoDemoSteps.steps", // Package containing the step definitions
    plugin = {
        "pretty", // Formats console output for better readability
        "html:target/cucumber/report.html", // Generates an HTML report in the specified directory
        "junit:target/reports/cucumber.xml", // Generates a JUnit XML report in the specified directory
        "json:target/reports/cucumber.json", // Generates a JSON report in the specified directory
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // Integration with ExtentReports for reports
    }
)
public class MagentoDemoRunnerTest extends AbstractTestNGCucumberTests {
   
}
