package magentoDemoSteps.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import testcontext.TestContext;

import org.openqa.selenium.WebDriver;

import browserconfiguration.BrowserConfiguration;

public class HomePageSteps {
    private final TestContext testContext;

    public HomePageSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I am on the homepage using {string}")
    public void i_am_on_the_homepage_using(String browser) {
        WebDriver driver = BrowserConfiguration.startBrowser(browser);
        testContext.setDriver(driver);
        driver.get("https://magento-demo.mageplaza.com/default/");
    }

    @After
    public void closeBrowser(Scenario scenario) {
        BrowserConfiguration.closeBrowser();
    }

}
