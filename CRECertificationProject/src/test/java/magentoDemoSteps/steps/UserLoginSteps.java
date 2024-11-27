package magentoDemoSteps.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.UserLogin;

import org.openqa.selenium.WebDriver;

import testcontext.TestContext;

public class UserLoginSteps {
    TestContext testContext;
    WebDriver driver;
    UserLogin userLogin;

    public UserLoginSteps(TestContext context) {
        this.testContext = context;
        this.driver = testContext.getDriver();
        userLogin = new UserLogin(driver);
    }

    @And("I navigate to the Magento-demo.mageplaza.com login page")
    public void i_navigate_to_the_magento_demo_mageplaza_com_login_page() {
        userLogin.signInButtonLocation();
    }

    @When("I enter a {string} and {string}")
    public void i_enter_a_email_and_password(String email, String password) {
        userLogin.emailInputField(email);
        userLogin.passwordInputField(password);
    }

    @And("I click the signin button")
    public void i_click_the_signin_button() {
        userLogin.signInButtonClick();
    }

    @Then("I should see my account dashboard")
    public void i_should_see_my_account_dashboard() {
        userLogin.userLoggedVerification();
    }


    @Then("I should see invalid email error message")
    public void i_should_see_an_error_message() {
        userLogin.validateInvalidEmailErrorMessage();
    }

}
