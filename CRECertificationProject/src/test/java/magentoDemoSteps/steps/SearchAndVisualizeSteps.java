package magentoDemoSteps.steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ProductSearchAndVisualization;
import testcontext.TestContext;

public class SearchAndVisualizeSteps {

	TestContext testContext;
	WebDriver driver;
	ProductSearchAndVisualization productSearchAndVisualization;
	
	
	public SearchAndVisualizeSteps(TestContext context) {
	    this.testContext = context;
	    this.driver = testContext.getDriver();
		productSearchAndVisualization = new ProductSearchAndVisualization(driver);
	}
	
	@When("I enter {string} in the search bar")
	public void i_enter_in_the_search_bar(String string) {
		productSearchAndVisualization.searchItemUsingSearchBar(string);
	}
	
	@And("I click the {string} button icon")
	public void i_click_the_button_icon(String string) {
		productSearchAndVisualization.clickSearchButton();
	}
	
	
	@Then("I should see a list of products related to {string}")
	public void i_should_see_a_list_of_products_related_to(String string) {
		productSearchAndVisualization.verifyProductsListVisible();
	}
	
	
	// 
	
	@And("I searched for {string} and results are displayed")
	public void i_searched_for_and_results_are_displayed(String string) {
		productSearchAndVisualization.searchItemUsingSearchBar(string);
		productSearchAndVisualization.clickSearchButton();
		productSearchAndVisualization.verifyProductsListVisible();
	}
	
	
	@When("I click on the first item")
	public void i_click_on_the_first_item() {
		productSearchAndVisualization.clickToVisualizeProductDetails();
	}
	
	@Then("I should be redirected to the product details page for {string}")
	public void i_should_be_redirected_to_the_product_details_page_for(String expectedName) {
		productSearchAndVisualization.itemPageDetails(expectedName);
	}
	
	@Then("I should see the {string}, {string}, {string}")
	public void i_should_see_the(String name, String price, String description) {
		productSearchAndVisualization.verifyProductDetails(name, price, description);
	}


}
