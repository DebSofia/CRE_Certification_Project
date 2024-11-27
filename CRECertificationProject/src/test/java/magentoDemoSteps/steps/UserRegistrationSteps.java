package magentoDemoSteps.steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.UserResgistration;
import testcontext.TestContext;

public class UserRegistrationSteps {
	TestContext testContext;
	WebDriver driver;
	UserResgistration userRegistration;

	public UserRegistrationSteps(TestContext context) {
        this.testContext = context; // Reutilizar o método context
        this.driver = testContext.getDriver(); // Reutilizar o driver
        userRegistration = new UserResgistration(driver);
    }
	
	@When("I fill in account registration with valid values")
	public void i_fill_in_account_registration_with_valid_values() {
		userRegistration.fillInAccountRegistrationWithRandomValues();
	}

	@And("I click the Create an Account button")
	public void i_click_the_create_an_account_button() {
		userRegistration.clickCreateAccountButton();
	}
	
	@Then("I should see a success message")
	public void i_should_see_a_success_message() {
		userRegistration.validateUserRegistrationConfirmationMessage();
	}
	
	@And("I should be redirected to the account dashboard")
	public void i_should_be_redirected_to_the_account_dashboard() {
		userRegistration.dashboardAccountValidation();
	}
	
	
	@When("I navigate to the Create an account page")
	public void i_navigate_to_the_create_an_account_page() {
        userRegistration.navigateToCreateAccountPage();
	}

	@When("I fill in account registration with invalid email")
	public void i_fill_in_account_registration_with_invalid_email() {
		userRegistration.fillInAccountRegistrationWithInvalidEmail();
	}

	@Then("It should display an error message {string}")
	public void it_should_display_an_error_message(String string) {
		userRegistration.validateErrorMessage();
	}

}
