package pageobjects;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearchAndVisualization {

	private final WebDriver driver;
	private WebElement searchBar;
	private WebElement searchButton;
	private WebElement itemLink;
	private WebElement productList;
	private WebElement itemName;
	private WebElement itemPrice;
	private WebElement itemDescription;

	public ProductSearchAndVisualization(WebDriver driver) {
		this.driver = driver;
	}

	public void searchItemUsingSearchBar(String searchTerm) {
		searchBar = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		searchBar.clear();
		for (String c : searchTerm.split("")) {
			searchBar.sendKeys(c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
	}

	public void clickSearchButton() {
		searchButton = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
		searchButton.click();
	}

	public void verifyProductsListVisible() {
		productList = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("toolbar-amount")));
		assertTrue(productList.isDisplayed());
	}

	public void clickToVisualizeProductDetails() {
		itemLink = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("div[id='product-item-info_40'] a[class='product-item-link']")));
		itemLink.click();
	}
	
	public void itemPageDetails(String expectedName) {
		itemName = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".base")));
		assertEquals(expectedName, itemName.getText());
	}
	

	public void verifyProductDetails(String name, String price, String description) {
		itemName = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".base")));
		assertEquals(name, itemName.getText());

		itemPrice = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".price")));
		assertEquals(price, itemPrice.getText());

		// Verify product description contains expected text
		itemDescription = new WebDriverWait(driver, Duration.ofSeconds(5))
	            .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tab-label-description-title")));
	    String actualDescription = itemDescription.getText();
	    assertTrue(
	        actualDescription.contains(description),
	        "Expected description to contain: " + description + " but was: " + actualDescription
	    );
	    
	   

	}

}
