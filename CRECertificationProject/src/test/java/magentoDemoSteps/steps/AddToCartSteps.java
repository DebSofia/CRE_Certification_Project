package magentoDemoSteps.steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AddProductToCart;
import pageobjects.ProductSearchAndVisualization;
import testcontext.TestContext;

public class AddToCartSteps {
	private final ProductSearchAndVisualization productSearchAndVisualization;
	TestContext testContext;
	WebDriver driver;
	AddProductToCart addProductToCart;

	public AddToCartSteps(TestContext context) {
		this.testContext = context; // Reuse context method
		this.driver = testContext.getDriver(); // Reuse the driver
		this.addProductToCart = new AddProductToCart(driver);
		this.productSearchAndVisualization = new ProductSearchAndVisualization(driver);
	}

	@And("I select the first item after searching {string}")
	public void i_select_the_first_item(String searchTerm) {
	    //productSearchAndVisualization.searchItemUsingSearchBar(searchTerm);
	    productSearchAndVisualization.clickSearchButton();
	    addProductToCart.selectFirstItem();
	}

	@When("I click on the Add to cart button")
	public void i_click_on_the_add_to_cart_button() {
		addProductToCart.addToShoppingCart();
	}

	@And("I click on the cart icon")
	public void i_click_on_the_cart_icon() {
		addProductToCart.clickShoppingCartIcon();
	}

	@Then("I should see a clickable proceed to checkout button")
	public void i_should_see_a_clickable_proceed_to_checkout_button() {
		addProductToCart.checkOutButton();
	}

}
