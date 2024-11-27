package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import randomcredentialsgenerator.RandomCredentialsGenerator;
import utils.StepUtils;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class UserResgistration {

	private final WebDriver driver;

	private String randomFirstName;
	private String randomLastName;
	private String randomPassword;
	private String randomEmail;

	private WebElement creatAnAccountLink;
	private WebElement firstNameInputField;
	private WebElement lastNameInputField;
	private WebElement emailInputField;
	private WebElement passowrdInputField;
	private WebElement confirmPasswordInputField;
	private WebElement createAccountButton;
	private WebElement accountCreationConfirmation;
	private WebElement accountDashoard;
	private WebElement errorMessage;

	public UserResgistration(WebDriver driver) {

		randomFirstName = RandomCredentialsGenerator.generateRandomName(6);
		randomLastName = RandomCredentialsGenerator.generateRandomName(6);
		randomEmail = RandomCredentialsGenerator.generateRandomEmail();
		randomPassword = RandomCredentialsGenerator.generateRandomPassword(10);

		this.driver = driver;
	}

	public void navigateToCreateAccountPage() {
		creatAnAccountLink = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.linkText("Create an Account")));
		creatAnAccountLink.click();
	}

	public void fillInAccountRegistrationWithRandomValues() {
		fillInAccountRegistration(randomFirstName, randomLastName, randomEmail, randomPassword);
	}

	public void fillInAccountRegistration(String firstName, String lastName, String email, String password) {
		firstNameInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#firstname")));

		StepUtils.slowSendKeys(firstName, firstNameInputField);
		
		//firstNameInputField.sendKeys(firstName);

		
		lastNameInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#lastname")));

		StepUtils.slowSendKeys(lastName, lastNameInputField);
		
		//lastNameInputField.sendKeys(lastName);
		
		
		
		emailInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email_address")));

		StepUtils.slowSendKeys(email, emailInputField);
		
		//emailInputField.sendKeys(email);
		
		passowrdInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));

		StepUtils.slowSendKeys(password, passowrdInputField);
		
		//passowrdInputField.sendKeys(password);
		

		confirmPasswordInputField = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password-confirmation")));

		StepUtils.slowSendKeys(password, confirmPasswordInputField);
		
		//confirmPasswordInputField.sendKeys(password);
	}

	public void clickCreateAccountButton() {
		createAccountButton = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
				.elementToBeClickable(By.id("send2")));
		createAccountButton.submit();
	}

	public void validateUserRegistrationConfirmationMessage() {
		accountCreationConfirmation = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")));
		String actualText = accountCreationConfirmation.getText();
		String expectedText = "Thank you for registering with Main Website Store.";

		assertEquals(expectedText, actualText);
	}

	public void dashboardAccountValidation() {

		accountDashoard = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".base")));
		String actualText = accountDashoard.getText();
		String expectedText = "My Account";

		assertEquals(expectedText, actualText);
	}
	
	
	public void fillInAccountRegistrationWithInvalidEmail() {
		fillInAccountRegistration(randomFirstName, randomLastName, "rurusa@", randomPassword);
	}
	
	public void validateErrorMessage() {
		errorMessage = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_address-error")));
		String actualText = errorMessage.getText();
		String expectedText = "Please enter a valid email address (Ex: johndoe@domain.com).";

		assertEquals(expectedText, actualText);
	}

}
