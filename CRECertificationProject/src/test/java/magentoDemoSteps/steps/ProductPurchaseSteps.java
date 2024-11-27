package magentoDemoSteps.steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ProductPurchase;
import testcontext.TestContext;

public class ProductPurchaseSteps {
	TestContext testContext;
	WebDriver driver;
	ProductPurchase productPurchase;

	public ProductPurchaseSteps(TestContext context) {
		this.testContext = context;
		this.driver = testContext.getDriver();
		productPurchase = new ProductPurchase(driver);

	}

	@And("I am autenticated with {string} and {string}")
	public void i_am_autenticated_with_and(String email, String password) {
		productPurchase.purchaseProductLogin(email, password); // Calls the purchaseProduct method to authenticate

	}


	@And("I add a product to the cart using {string}")
	public void i_add_a_product_to_the_cart_using(String searchTerm) {
		productPurchase.purchaseProductAddToCart(searchTerm);
	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
		productPurchase.purchaseProductCheckOutPage();
	}
	
	
	@When("I already have my account details filled")
	public void i_already_have_my_account_details_filled() {
		productPurchase.accountDetails();
	}
	
	
	@And("I select a payment method")
	public void i_select_a_payment_method() {
		productPurchase.choosePaymentMethod();
	}
	
	@And("I confirm the order")
	public void i_confirm_the_order() {
		productPurchase.confirmOrder();
	}
	
	@Then("I should see a confirmation message {string}")
	public void i_should_see_a_confirmation_message(String string) {
		productPurchase.orderConfirmation();
	}

}
