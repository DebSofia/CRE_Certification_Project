package pageobjects;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPurchase {
	private final WebDriver driver;

	// Create instances of the classes whose methods you want to reuse
	private UserLogin userLogin;
	private AddProductToCart addProductToCart;
	private ProductSearchAndVisualization productSearch;
	private WebElement shippingMethod;
	private WebElement nextButton;
	private WebElement shippingAdressDetails;
	private WebElement paymentMethod;
	private WebElement placeOrderButton;
	private WebElement orderConfirmation;

	Select country;
	Select state;

	public ProductPurchase(WebDriver driver) {
		this.driver = driver;
		this.userLogin = new UserLogin(driver); // Instantiate UserLogin
		this.addProductToCart = new AddProductToCart(driver); // Instantiate AddProductToCart
		this.productSearch = new ProductSearchAndVisualization(driver);

	}

	
	public void purchaseProductLogin(String email, String password) {
		// 1. Sign in to the website
		// Added a thread sleep and a try catch error, due to bugs during
		// Firefox browser testing
		// Error encountered: the login credentials where being written
		// At the same time the item at the search bar
		// Then after the steps of adding the item to the shopping cart
		// It was verified that the user was not logged in
		// Which is not compatible with the test: the user must be logged in
		// To proceed to checkout 
		
		try {

			// Sleep for 3 seconds (3000 milliseconds)
			Thread.sleep(3000); 
			userLogin.signInButtonLocation();
			userLogin.emailInputField(email);
			userLogin.passwordInputField(password);
			userLogin.signInButtonClick();

		} catch (TimeoutException e) {
			System.err.println("Could not find a clickable element called chekmo" + e.getMessage());
			fail("Expected checkmo to be clickable " + e.getMessage());

		} catch (Exception e) {
			// Catch any other exceptions and print the error
			System.err.println("An error occurred: " + e.getMessage());
			fail("An error occurred: " + e.getMessage());
		}

	}

	public void purchaseProductAddToCart(String searchTerm) {
		try {

			// Sleep for 3 seconds (3000 milliseconds)
			Thread.sleep(3000); // This is the simple fixed wait
			productSearch.searchItemUsingSearchBar(searchTerm);
			productSearch.clickSearchButton();
			addProductToCart.selectFirstItem(); // Select first item
			addProductToCart.addToShoppingCart(); // Add the selected item to cart
			addProductToCart.clickShoppingCartIcon(); // Open the shopping cart

		} catch (TimeoutException e) {
			System.err.println("Could not find a clickable element called chekmo" + e.getMessage());
			fail("Expected checkmo to be clickable " + e.getMessage());

		} catch (Exception e) {
			// Catch any other exceptions and print the error
			System.err.println("An error occurred: " + e.getMessage());
			fail("An error occurred: " + e.getMessage());
		}

	}

	public void purchaseProductCheckOutPage() {
		addProductToCart.checkOutButton(); // Proceed to checkout
	}

	public void accountDetails() {

		shippingAdressDetails = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("span[data-bind=\"i18n: 'New Address'\"]")));
		String actualText = shippingAdressDetails.getText();
		String expectedText = "New Address";

		assertEquals(expectedText, actualText);

		shippingMethod = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.name("ko_unique_1")));
		shippingMethod.click();

		nextButton = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[data-bind=\"i18n: 'Next'\"]")));
		nextButton.submit();

	}

	public void choosePaymentMethod() {

		try {

			// Sleep for 3 seconds (3000 milliseconds)
			Thread.sleep(3000); 
			paymentMethod = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(By.id("checkmo")));
			paymentMethod.click();

		} catch (TimeoutException e) {
			System.err.println("Could not find a clickable element called chekmo" + e.getMessage());
			fail("Expected checkmo to be clickable " + e.getMessage());

		} catch (Exception e) {
			// Catch any other exceptions and print the error
			System.err.println("An error occurred: " + e.getMessage());
			fail("An error occurred: " + e.getMessage());
		}

	}

	public void confirmOrder() {
		try {

			// Sleep for 3 seconds (3000 milliseconds)
			Thread.sleep(3000); // This is the simple fixed wait
			placeOrderButton = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(
							By.cssSelector("div[class='payment-method _active'] button[title='Place Order'] span")));
			placeOrderButton.click();
		} catch (TimeoutException e) {
			System.err.println("Could not find a clickable element called chekmo" + e.getMessage());
			fail("Expected checkmo to be clickable " + e.getMessage());

		}

		catch (Exception e) {
			// Catch any other exceptions and print the error
			System.err.println("An error occurred: " + e.getMessage());
			fail("An error occurred: " + e.getMessage());
		}

	}

	public void orderConfirmation() {

		orderConfirmation = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p:nth-child(2)")));
		String actualText = orderConfirmation.getText();
		String expectedText = "We'll email you an order confirmation with details and tracking info.";

		assertEquals(expectedText, actualText);

	}

}
