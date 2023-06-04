package stepdef;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LastItemPage;
import pages.SearchPage;
import pages.MainPage;
import utils.DriverHelper;

public class WebstaurantStoreStepDef {
    WebDriver driver = DriverHelper.getDriver();
    MainPage mainPage = new MainPage(driver);
    SearchPage search = new SearchPage(driver);
    LastItemPage addItem = new LastItemPage(driver);
    CartPage cart = new CartPage(driver);

    @Given("User search for {string}")
    public void user_search_for(String productName) {

    mainPage.searchForProduct(productName);

    }
    @Then("User validates that each product title contains word {string}")
    public void user_validates_that_each_product_title_contains_word(String expectedContainedWord) throws InterruptedException {
        search.validateEachProductName(driver,expectedContainedWord);
        search.printOutListOfProductsWithNoTableWord();
        search.addLastItemToCart();
        addItem.addToCartItem(driver);
    }
    @Then("User adds last item to cart and clears the cart to validate message {string}")
    public void user_adds_last_item_to_cart_and_clears_the_cart_to_validate_message(String expectedMessage) {
    cart.validateCartIsEmpty(expectedMessage);
    }



}
