package pageobjects;

import static org.junit.Assert.assertEquals;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductToCart {
	private final WebDriver driver;

	//private WebElement searchBar;
	//private WebElement searchButton;
	private WebElement addToCartButton;
	private WebElement shoppingCartIcon;
	private WebElement proceedToCheckOutButton;
	private WebElement checkOutPageConfirmation;
	private WebElement firstItem;

	public AddProductToCart(WebDriver driver) {
		this.driver = driver;
	}

	public void selectFirstItem() {
		firstItem = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("div[id='product-item-info_8'] a[class='product-item-link']")));
		firstItem.click();
	}

	public void addToShoppingCart() {
		addToCartButton = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));
		addToCartButton.submit();
	}

	public void clickShoppingCartIcon() {

		// This try catch gives the browser time to process that that
		// An item was added to the shopping cart before clicking
		// On the shopping cart icon

		try {

			// Sleep for 5 seconds (5000 milliseconds)
			Thread.sleep(5000); // This is the simple fixed wait
			shoppingCartIcon = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action.showcart")));
			shoppingCartIcon.click();
		} catch (Exception e) {
			// Catch any other exceptions and print the error
			System.err.println("An error occurred: " + e.getMessage());
		}

	}

	public void checkOutButton() {
		proceedToCheckOutButton = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.id("top-cart-btn-checkout")));
		proceedToCheckOutButton.click();

		checkOutPageConfirmation = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("li[id='shipping'] div[class='step-title']")));
		String actualText = checkOutPageConfirmation.getText();
		String expectedText = "Shipping Address";

		assertEquals(expectedText, actualText);

	}

}
