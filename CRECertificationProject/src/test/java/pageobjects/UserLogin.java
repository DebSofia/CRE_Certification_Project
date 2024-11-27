package pageobjects;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.StepUtils;

public class UserLogin {

	private final WebDriver driver;
	private WebElement signIn;
	private WebElement emailField;
	private WebElement passwordField;
	private WebElement signInButton;
	private WebElement logInAssert;
	private WebElement messageErrorAssertion;

	public UserLogin(WebDriver driver) {
		this.driver = driver;

	}

	public void signInButtonLocation() {
		signIn = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")));
		signIn.click();

	}

	public void emailInputField(String email) {
		emailField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));

		StepUtils.slowSendKeys(email, emailField);

		
	}

	public void passwordInputField(String password) {
		passwordField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")));

		StepUtils.slowSendKeys(password, passwordField);

		
	}

	public void signInButtonClick() {
		signInButton = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.id("send2")));
		signInButton.submit();
	}

	public void userLoggedVerification() {

		try {

			// Sleep for 5 seconds (5000 milliseconds)
			Thread.sleep(5000); // This is the simple fixed wait

			logInAssert = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Tatyana Salinas!']")));
			String actualText = logInAssert.getText();
			String expectedText = "Welcome, Tatyana Salinas!";

			assertEquals(expectedText, actualText);

		} catch (Exception e) {
			// Catch any other exceptions and print the error
			System.err.println("An error occurred: " + e.getMessage());
			throw new RuntimeException(e);
		}

	}

	public void validateInvalidEmailErrorMessage() {

		try {

			messageErrorAssertion = new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-error")));
			String actualText = messageErrorAssertion.getText();
			String expectedText = "Please enter a valid email address (Ex: johndoe@domain.com).";

			assertEquals(expectedText, actualText);

			// Sleep for 5 seconds (5000 milliseconds)
			Thread.sleep(5000); // This is the simple fixed wait

		} catch (Exception e) {
			// Catch any other exceptions and print the error
			System.err.println("An error occurred: " + e.getMessage());
			throw new RuntimeException(e);
		}

	}

}
